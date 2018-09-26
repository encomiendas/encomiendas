package py.com.domainsoft.web.view;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.common.domain.Pager;
import py.com.domainsoft.entidad.services.ActividadEconomicaService;
import py.com.domainsoft.entidad.services.PaisService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.PersonaDTO;
import py.com.domainsoft.seguridad.dtos.TipoDocumentoDTO;
import py.com.domainsoft.seguridad.dtos.TipoPersonaDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.services.PersonaService;
import py.com.domainsoft.seguridad.services.TipoDocumentoService;
import py.com.domainsoft.seguridad.services.TipoPersonaService;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class PersonaViewController extends BaseViewController{
    
    private static final String PERSONA_LISTA = "/persona-lista";
    private static final String PERSONA_EXITOSO = "/persona-exitoso";
    
    private final PersonaService personaService;
    private final TipoDocumentoService tipoDocumentoService;
    private final TipoPersonaService tipoPersonaService;
    private final ActividadEconomicaService actividadEconomicaService;
    private final PaisService paisService;

    public PersonaViewController(PersonaService personaService,
            TipoDocumentoService tipoDocumentoService,
            TipoPersonaService tipoPersonaService,
            ActividadEconomicaService actividadEconomicaService,
            PaisService paisService) {
        this.personaService = personaService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.tipoPersonaService = tipoPersonaService;
        this.actividadEconomicaService = actividadEconomicaService;
        this.paisService = paisService;
    }

    @GetMapping(PERSONA_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("cliente/persona-lista");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.PEOPLE_INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<PersonaDTO> personaPaginado = personaService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(personaPaginado.getTotalPages(), personaPaginado.getNumber(),
                Constantes.BUTTONS_TO_SHOW);


        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) 
                session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, 
                (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
        modelAndView.addObject("persona", new PersonaDTO());
        modelAndView.addObject("tipoDocumento", new TipoDocumentoDTO());
        modelAndView.addObject("tipoPersona", new TipoPersonaDTO());
        modelAndView.addObject("tiposDoc", tipoDocumentoService.findAll());
        modelAndView.addObject("tiposPersonas", tipoPersonaService.findAll());
        modelAndView.addObject("actividadesEconomicas", actividadEconomicaService.findAll());
        modelAndView.addObject("paises", paisService.findAll());
       
        //Paginacion
        modelAndView.addObject("personas", personaPaginado);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("message", null);

        return modelAndView;
    }

    @PostMapping(PERSONA_LISTA)
    public ModelAndView grabarPagina(@Valid PersonaDTO persona,
            BindingResult bindingResult) {

        personaService.grabarPersona(persona);

        return new ModelAndView("redirect:/persona-exitoso");
    }

    @GetMapping(PERSONA_EXITOSO)
    public ModelAndView paginaExitoso() {
        ModelAndView modelAndView = new ModelAndView(
                "cliente/persona-exitoso");

        return modelAndView;
    }
}