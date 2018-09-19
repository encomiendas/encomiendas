package py.com.domainsoft.web.view;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.common.domain.Pager;
import py.com.domainsoft.entidad.services.SucursalService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;
import py.com.domainsoft.seguridad.services.PersonaService;
import py.com.domainsoft.seguridad.services.UsuarioService;

@Controller
public class UsuarioViewController {
    
    private static final String USUARIO_LISTA = "/usuario-lista";
    private static final String USUARIO_EXITOSO = "/usuario-exitoso";
    
    private final UsuarioService usuarioService;
    private final PersonaService personaService;
    private final SucursalService sucursalService;

    public UsuarioViewController(
            UsuarioService usuarioService,
            PersonaService personaService,
            SucursalService sucursalService) {
        this.usuarioService = usuarioService;
        this.personaService = personaService;
        this.sucursalService = sucursalService;
    }

    @GetMapping(USUARIO_LISTA)
    public String usuarioLista(
            Model modelAndView,
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        //ModelAndView modelAndView = new ModelAndView("seguridad/usuario-lista");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<UsuarioDTO> persons = usuarioService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        UsuarioDTO user = new UsuarioDTO();

        modelAndView.addAttribute(Constantes.MENU_LIST, (List<MenuDTO>) 
                session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addAttribute(Constantes.SESSION_LOGIN_DATA, 
                (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addAttribute("listpersonasAll", personaService.findAll());
        modelAndView.addAttribute("listsucursalesAll", sucursalService.findAll());
        
        modelAndView.addAttribute("usuario", user);
        modelAndView.addAttribute("persons", persons);
        modelAndView.addAttribute("selectedPageSize", evalPageSize);
        modelAndView.addAttribute("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addAttribute("pager", pager);
        modelAndView.addAttribute("message", null);

        return "seguridad/usuario-lista";
    }

    @PostMapping(USUARIO_LISTA)
    public ModelAndView grabarUsuario(Model model, 
            @Valid @ModelAttribute("user") UsuarioDTO user,
            BindingResult bindingResult) {
        
        if (user.getIdUsuario() != null) {
            usuarioService.actualizarUsuario(user);
        }else{
            usuarioService.grabarUsuario(user);
        }

        return new ModelAndView("redirect:/usuario-exitoso");
    }

    @GetMapping(USUARIO_EXITOSO)
    public ModelAndView usuarioExitoso() {
        ModelAndView modelAndView = new ModelAndView(
                "seguridad/usuario-exitoso");

        return modelAndView;
    }
}