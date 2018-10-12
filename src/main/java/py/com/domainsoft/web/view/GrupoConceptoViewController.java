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
import py.com.domainsoft.envios.dtos.GrupoConceptoDTO;
import py.com.domainsoft.envios.services.GrupoConceptoService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@Controller
public class GrupoConceptoViewController {
	
	
	private static final String GRUPO_CONCEPTO_LISTA = "/grupo-concepto-lista";
	private static final String GRUPO_CONCEPTO_EXITOSO = "/grupo-concepto-exitoso";
	
	
	private final GrupoConceptoService grupoConceptoService;
	
	public GrupoConceptoViewController(GrupoConceptoService grupoConceptoService) {
		this.grupoConceptoService = grupoConceptoService;
	}
	
	
	@GetMapping(GRUPO_CONCEPTO_LISTA)
	public ModelAndView paginaLista(@RequestParam("pageSize") Optional<Integer> tamanhoPagina,
			@RequestParam("page") Optional<Integer> numeroPagina, HttpSession session) {
		
		
		ModelAndView modelAndView = new ModelAndView("envios/grupo-concepto-lista");
		
		/**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;
        
        
        Page<GrupoConceptoDTO> grupoConceptoPaginado = grupoConceptoService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(grupoConceptoPaginado.getTotalPages(), grupoConceptoPaginado.getNumber(),
                Constantes.BUTTONS_TO_SHOW);
		
		
        GrupoConceptoDTO grupoConcepto = new GrupoConceptoDTO();
        
        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
        modelAndView.addObject("grupoConcepto", grupoConcepto);
        //Paginacion
        modelAndView.addObject("grupoConceptos", grupoConceptoPaginado);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("message", null);
        
        
        return modelAndView;
	}	
	
	@PostMapping(GRUPO_CONCEPTO_LISTA)
	public ModelAndView grabarPagina(@Valid GrupoConceptoDTO grupoConcepto, BindingResult bindingResult) {

		grupoConceptoService.grabarGrupoConcepto(grupoConcepto);

		return new ModelAndView("redirect:"+GRUPO_CONCEPTO_EXITOSO);
	}

	@GetMapping(GRUPO_CONCEPTO_EXITOSO)
	public ModelAndView paginaExitoso() {
		
		String htmlpadre = GRUPO_CONCEPTO_LISTA;
    	String msgexitoso = "Se aplicaron exitosamento los datos de Grupo Concepto";
    	
    	ModelAndView modelAndView = new ModelAndView(Constantes.MSG_EXITOSO_URL);
    	modelAndView.addObject("htmlpadre",htmlpadre);
    	modelAndView.addObject("msgexitoso",msgexitoso);

		return modelAndView;
	}	

}
