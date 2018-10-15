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
import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;
import py.com.domainsoft.envios.services.UnidadNegocioService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@Controller
public class UnidadNegocioViewController {
    
	private static final String UNIDAD_NEGOCIO_LISTA = "/unidad-negocio-lista";
	private static final String UNIDAD_NEGOCIO_EXITOSO = "/unidad-negocio-exitoso";
	
	
	private final UnidadNegocioService unidadNegocioService;

    public UnidadNegocioViewController(UnidadNegocioService unidadNegocioService) {
        this.unidadNegocioService = unidadNegocioService;
    }

    
    @GetMapping(UNIDAD_NEGOCIO_LISTA)
    public ModelAndView unidadNegocioLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("envios/unidad-negocio");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<UnidadNegocioDTO> listobj = unidadNegocioService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(listobj.getTotalPages(), listobj.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        UnidadNegocioDTO unidadNegDto = new UnidadNegocioDTO();
        
        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        

        modelAndView.addObject("unidadNegDto", unidadNegDto);
        //Paginacion
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;
    }

    @PostMapping(value = UNIDAD_NEGOCIO_LISTA)
    public ModelAndView createNewUnidadNegocio(@Valid UnidadNegocioDTO unidadNegocioDto,
            BindingResult bindingResult) {
    	unidadNegocioService.grabarUnidadNegocio(unidadNegocioDto);
        return new ModelAndView("redirect:"+UNIDAD_NEGOCIO_EXITOSO);
    }

    
    
    @GetMapping(value = UNIDAD_NEGOCIO_EXITOSO)
    public ModelAndView usuarioExitoso() {
        
    	String htmlpadre = UNIDAD_NEGOCIO_LISTA;
    	String msgexitoso = "Se aplicaron exitosamento los datos de Unidad de Negocio";
    	
    	ModelAndView modelAndView = new ModelAndView(Constantes.MSG_EXITOSO_URL);
    	modelAndView.addObject("htmlpadre",htmlpadre);
    	modelAndView.addObject("msgexitoso",msgexitoso);
    	
    	
    	

        return modelAndView;
    }
}