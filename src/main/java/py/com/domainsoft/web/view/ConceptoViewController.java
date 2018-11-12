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
import py.com.domainsoft.envios.dtos.ConceptoDTO;
import py.com.domainsoft.envios.services.ConceptoService;
import py.com.domainsoft.envios.services.GrupoConceptoService;
import py.com.domainsoft.envios.services.TipoImpuestoService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@Controller
public class ConceptoViewController {

	private static final String CONCETO_LISTA = "/concepto-lista";
    private static final String CONCEPTO_EXITOSO = "/concepto-exitoso";
    
    private final ConceptoService conceptoService;
    private final TipoImpuestoService tipoImpuestoService;
    private final GrupoConceptoService grupoConceptoService;
    
    public ConceptoViewController (
    		ConceptoService conceptoService,
    		TipoImpuestoService tipoImpuestoService,
    		GrupoConceptoService grupoConceptoService) {
    	this.conceptoService = conceptoService;
    	this.tipoImpuestoService = tipoImpuestoService;
    	this.grupoConceptoService = grupoConceptoService; 
    	
    	
    } 
    
    @GetMapping(CONCETO_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("envios/concepto-lista");
        
        
        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.PEOPLE_INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<ConceptoDTO> listobj = conceptoService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(listobj.getTotalPages(), listobj.getNumber(),
                Constantes.BUTTONS_TO_SHOW);
        
        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) 
                session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, 
                (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
      //Datos
        modelAndView.addObject("concepto", new ConceptoDTO());
        modelAndView.addObject("grupoConceptos", grupoConceptoService.findAll());
        modelAndView.addObject("tipoImpuestos", tipoImpuestoService.findAll());
        
       //Paginacion
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        
        
        return modelAndView;
        
    }   
    
    
    @PostMapping(value = CONCETO_LISTA)
    public ModelAndView createNewUnidadNegocio(@Valid ConceptoDTO conceptoDto,
            BindingResult bindingResult) {
    	
    	conceptoService.grabarConcepto(conceptoDto);
        
    	return new ModelAndView("redirect:"+CONCEPTO_EXITOSO);
    }
    
    @GetMapping(value = CONCEPTO_EXITOSO)
    public ModelAndView tipoImpuestoExitoso() {
        
    	String htmlpadre = CONCETO_LISTA;
    	String msgexitoso = "Se aplicaron exitosamento los datos de Concepto";
    	
    	ModelAndView modelAndView = new ModelAndView(Constantes.MSG_EXITOSO_URL);
    	modelAndView.addObject("htmlpadre",htmlpadre);
    	modelAndView.addObject("msgexitoso",msgexitoso);
    	
        return modelAndView;
    }
    
    
}
