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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.common.domain.Pager;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.services.MenuService;
import py.com.domainsoft.seguridad.services.PerfilService;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class PerfilViewController extends BaseViewController {

    private static final String PERFIL_LISTA = "/perfil-lista";
    private static final String PERFIL_EXITOSO = "/perfil-exitoso";
    private static final String PERFIL_RELOAD = "/reload-perfil-menu/{idPerfil}";
    
    private final PerfilService perfilService;
    private final MenuService menuService;

    public PerfilViewController(PerfilService perfilService,
            MenuService menuService) {
        this.perfilService = perfilService;
        this.menuService = menuService;
    }
    
    @GetMapping(PERFIL_RELOAD)
    public ModelAndView reloadPerfil(
            @PathVariable("idPerfil") Integer idPerfil, 
            HttpSession session) {

        List<MenuDTO> listaMenu = menuService.getMenuByPerfil(idPerfil);
        session.setAttribute(Constantes.SESSION_MENU, listaMenu);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(PERFIL_LISTA)
    public ModelAndView perfilLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("seguridad/perfil-lista");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<PerfilDTO> paginas = perfilService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(paginas.getTotalPages(), paginas.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        PerfilDTO perfil = new PerfilDTO();

        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) 
                session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, 
                (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
        modelAndView.addObject("perfil", perfil);
        modelAndView.addObject("persons", paginas);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("message", null);

        return modelAndView;
    }

    @PostMapping(PERFIL_LISTA)
    public ModelAndView grabarPerfil(@Valid PerfilDTO perfil,
            BindingResult bindingResult) {

        perfilService.grabarPerfil(perfil);

        return new ModelAndView("redirect:/perfil-exitoso");
    }

    @GetMapping(PERFIL_EXITOSO)
    public ModelAndView perfilExitoso() {
        ModelAndView modelAndView = new ModelAndView(
                "seguridad/perfil-exitoso");

        return modelAndView;
    }
    
}
