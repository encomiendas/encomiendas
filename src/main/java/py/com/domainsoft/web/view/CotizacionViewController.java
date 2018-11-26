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
import py.com.domainsoft.entidad.services.SucursalService;
import py.com.domainsoft.envios.dtos.CotizacionDTO;
import py.com.domainsoft.envios.services.CotizacionService;
import py.com.domainsoft.envios.services.MonedaService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.services.UsuarioService;

@Controller
public class CotizacionViewController {
	
	private static final String COTIZACION_LISTA = "/cotizacion-lista";
    private static final String COTIZACION_EXITOSO = "/cotizacion-exitoso";
    
    private final CotizacionService cotizacionService;
    private final MonedaService monedaService;
    private final UsuarioService usuarioService;
    
    private static String msj = null;
    
    
    
    public CotizacionViewController(CotizacionService cotizacionService,
    		MonedaService monedaService,
    		UsuarioService usuarioService,
    		SucursalService sucursalService) {
    	this.cotizacionService = cotizacionService;
    	this.monedaService = monedaService;
    	this.usuarioService = usuarioService;
    	
    }
    
    
    @GetMapping(COTIZACION_LISTA)
    public ModelAndView cotiacionLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView("envios/cotizacion-lista");
        
        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.PEOPLE_INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;
        
        Page<CotizacionDTO> listobj = cotizacionService
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
        modelAndView.addObject("cotizacion", new CotizacionDTO());
        modelAndView.addObject("monedasDe", monedaService.findAll());
        modelAndView.addObject("monedasA", monedaService.findAll());
        modelAndView.addObject("message", msj);
        
        //Paginacion
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        
        return modelAndView;
    }
    
    
	@PostMapping(value = COTIZACION_LISTA)
	public ModelAndView createNewCotizacion(@Valid CotizacionDTO cotizacionDto, BindingResult bindingResult,
			HttpSession session) {

		
		msj = null;
		System.out.println(cotizacionDto.getMonedaDe().getIdMoneda());
		Boolean error = false;
		if (cotizacionDto.getMonedaDe().getIdMoneda() == null) { 
			error = true;
			msj = "Deba seleccionar las monedas";
		}
		
		if (cotizacionDto.getMonedaA().getIdMoneda() == null) {
			error = true;
			msj = "Deba seleccionar las monedas";
		}
		
		if (error) {
			ModelAndView modelAndView = new ModelAndView("redirect:" + COTIZACION_LISTA);
			return modelAndView;
		}		
		
		cotizacionDto.setSucursal(((UserDetailsDTO) session.getAttribute(Constantes.SESSION_LOGIN_DATA)).getSucursal());
		String username = ((UserDetailsDTO) session.getAttribute(Constantes.SESSION_LOGIN_DATA)).getUsername();
		cotizacionDto.setUsuarioLog(usuarioService.findByLogin(username));
		cotizacionDto.setFechaLog(Constantes.traerFechaHora());
		cotizacionService.grabarCotizacion(cotizacionDto);
		
		return new ModelAndView("redirect:" + COTIZACION_EXITOSO);
	}
    
    @GetMapping(value = COTIZACION_EXITOSO)
    public ModelAndView tipoImpuestoExitoso() {
        
    	String htmlpadre = COTIZACION_LISTA;
    	String msgexitoso = "Se aplicaron exitosamento los datos de Cotización";
    	
    	ModelAndView modelAndView = new ModelAndView(Constantes.MSG_EXITOSO_URL);
    	modelAndView.addObject("htmlpadre",htmlpadre);
    	modelAndView.addObject("msgexitoso",msgexitoso);
    	
        return modelAndView;
    }
    

}
