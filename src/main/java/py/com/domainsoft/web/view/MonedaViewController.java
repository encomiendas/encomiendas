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
import py.com.domainsoft.envios.dtos.MonedaDTO;
import py.com.domainsoft.envios.services.MonedaService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class MonedaViewController extends BaseViewController{
    
    private static final String MONEDA_LISTA = "/moneda-lista";
    private static final String MONEDA_EXITOSO = "/moneda-exitoso";
    
    private final MonedaService monedaService;

    public MonedaViewController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    @GetMapping(MONEDA_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("envios/moneda-lista");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<MonedaDTO> listobj = monedaService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(listobj.getTotalPages(), listobj.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        MonedaDTO user = new MonedaDTO();

        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) 
                session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, 
                (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
        modelAndView.addObject("moneda", user);
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("message", null);

        return modelAndView;
    }

    @PostMapping(MONEDA_LISTA)
    public ModelAndView grabarMoneda(@Valid MonedaDTO pagina,
            BindingResult bindingResult) {

        monedaService.grabarMoneda(pagina);
        
        return new ModelAndView("redirect:"+MONEDA_EXITOSO);
    }

    @GetMapping(MONEDA_EXITOSO)
    public ModelAndView monedaExitoso() {
    	
    	String htmlpadre = MONEDA_LISTA;
    	String msgexitoso = "Se aplicaron exitosamente los datos de Moneda";
    	
    	ModelAndView modelAndView = new ModelAndView(Constantes.MSG_EXITOSO_URL);
    	modelAndView.addObject("htmlpadre",htmlpadre);
    	modelAndView.addObject("msgexitoso",msgexitoso);
    	
    	return modelAndView;
    }
}








