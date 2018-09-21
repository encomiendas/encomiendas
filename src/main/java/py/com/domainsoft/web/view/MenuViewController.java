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
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PaginaDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.services.MenuService;
import py.com.domainsoft.seguridad.services.PaginaService;
import py.com.domainsoft.seguridad.services.PerfilService;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class MenuViewController extends BaseViewController{
    
    private static final String MENU_LISTA = "/menu-lista";
    private static final String MENU_EXITOSO = "/menu-exitoso";
    
    private final MenuService menuService;
    private final PerfilService perfilService;
    private final PaginaService paginaService;

    public MenuViewController(MenuService menuService,
            PerfilService perfilService,
            PaginaService paginaService) {
        this.menuService = menuService;
        this.perfilService = perfilService;
        this.paginaService = paginaService;
    }

    @GetMapping(MENU_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("seguridad/menu-lista");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<MenuDTO> menuPaginado = menuService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(menuPaginado.getTotalPages(), menuPaginado.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        MenuDTO menu = new MenuDTO();

        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
        modelAndView.addObject("perfil", new PerfilDTO());
        modelAndView.addObject("perfiles", perfilService.findAll());
        
        modelAndView.addObject("pagina", new PaginaDTO());
        modelAndView.addObject("paginas", paginaService.findAll());
        
        modelAndView.addObject("menu", menu);
        modelAndView.addObject("menusList", menuService.findAll());
        //Paginacion
        modelAndView.addObject("menus", menuPaginado);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("message", null);

        return modelAndView;
    }

    @PostMapping(MENU_LISTA)
    public ModelAndView grabarPagina(@Valid MenuDTO menu,
            BindingResult bindingResult) {

        menuService.grabarMenu(menu);

        return new ModelAndView("redirect:/menu-exitoso");
    }

    @GetMapping(MENU_EXITOSO)
    public ModelAndView paginaExitoso() {
        ModelAndView modelAndView = new ModelAndView(
                "seguridad/menu-exitoso");

        return modelAndView;
    }
}