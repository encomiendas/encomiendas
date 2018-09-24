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
import py.com.domainsoft.seguridad.services.PaginaService;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class PaginaViewController extends BaseViewController{
    
    private static final String PAGINA_LISTA = "/pagina-lista";
    private static final String PAGINA_EXITOSO = "/pagina-exitoso";
    
    private final PaginaService paginaService;

    public PaginaViewController(PaginaService paginaService) {
        this.paginaService = paginaService;
    }

    @GetMapping(PAGINA_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("seguridad/pagina-lista");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<PaginaDTO> paginas = paginaService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(paginas.getTotalPages(), paginas.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        PaginaDTO user = new PaginaDTO();

        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) 
                session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, 
                (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
        modelAndView.addObject("pagina", user);
        modelAndView.addObject("persons", paginas);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("message", null);

        return modelAndView;
    }

    @PostMapping(PAGINA_LISTA)
    public ModelAndView grabarPagina(@Valid PaginaDTO pagina,
            BindingResult bindingResult) {

        paginaService.grabarPagina(pagina);

        return new ModelAndView("redirect:/pagina-exitoso");
    }

    @GetMapping(PAGINA_EXITOSO)
    public ModelAndView paginaExitoso() {
        ModelAndView modelAndView = new ModelAndView(
                "seguridad/pagina-exitoso");

        return modelAndView;
    }
}