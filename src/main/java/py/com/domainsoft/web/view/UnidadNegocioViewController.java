package py.com.domainsoft.web.view;

import java.util.Optional;

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

@Controller
public class UnidadNegocioViewController {
    
    private final UnidadNegocioService unidadNegocioService;

    public UnidadNegocioViewController(UnidadNegocioService unidadNegocioService) {
        this.unidadNegocioService = unidadNegocioService;
    }

    
    @GetMapping("/unidad-negocio-lista")
    public ModelAndView unidadNegocioLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina) {

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

        modelAndView.addObject("unidadNegDto", unidadNegDto);
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;
    }

    @PostMapping(value = "/unidad-negocio-lista")
    public ModelAndView createNewUnidadNegocio(@Valid UnidadNegocioDTO unidadNegocioDto,
            BindingResult bindingResult) {
    	unidadNegocioService.grabarUnidadNegocio(unidadNegocioDto);
        return new ModelAndView("redirect:/unidad-negocio-exitoso");
    }

    
    
    @GetMapping(value = "/unidad-negocio-exitoso")
    public ModelAndView usuarioExitoso() {
        
    	String htmlpadre = "/unidad-negocio-lista";
    	String msgexitoso = "Se aplicaron exitosamento los datos de Unidad de Negocio";
    	
    	ModelAndView modelAndView = new ModelAndView("seguridad/usuario-exitoso");
    	modelAndView.addObject("htmlpadre",htmlpadre);
    	modelAndView.addObject("msgexitoso",msgexitoso);
    	
    	
    	

        return modelAndView;
    }
}