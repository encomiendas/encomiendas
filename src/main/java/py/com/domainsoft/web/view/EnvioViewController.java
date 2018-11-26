package py.com.domainsoft.web.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.entidad.dtos.EnvioDTO;
import py.com.domainsoft.entidad.dtos.EnvioDetDTO;
import py.com.domainsoft.entidad.services.PaisService;
import py.com.domainsoft.entidad.services.SucursalService;
import py.com.domainsoft.envios.services.ConceptoService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.services.TipoDocumentoService;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class EnvioViewController extends BaseViewController {

    private static final String ENVIAR_GIRO = "/enviar-giro";
    private static final String ENVIO_EXITOSO = "/envio-exitoso";

    private final SucursalService sucursalService;
    private final ConceptoService conceptoService;
    private final PaisService paisService;
    private final TipoDocumentoService tipoDocumentoService;

    public EnvioViewController(SucursalService sucursalService,
            ConceptoService conceptoService,
            TipoDocumentoService tipoDocumentoService,
            PaisService paisService) {
        this.sucursalService = sucursalService;
        this.conceptoService = conceptoService;
        this.tipoDocumentoService = tipoDocumentoService;
        this.paisService = paisService;
    }

    @GetMapping(ENVIAR_GIRO)
    public ModelAndView paginaLista(HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("envios/enviar-giro");

        modelAndView.addObject(Constantes.MENU_LIST,
                (List<MenuDTO>) session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA,
                (UserDetailsDTO) session
                        .getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios",
                (List<PerfilDTO>) session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles",
                (Integer) session.getAttribute("totalPerfiles"));

        modelAndView.addObject("envio", new EnvioDTO());
        modelAndView.addObject("envioDet", new EnvioDetDTO());
        modelAndView.addObject("sucursales", sucursalService.findAll());
        // 2 - GIROS
        modelAndView.addObject("conceptos",
                conceptoService.findByGrupoConcepto(2));
        modelAndView.addObject("paises", paisService.findAll());
        modelAndView.addObject("tiposDoc", tipoDocumentoService.findAll());

        return modelAndView;
    }

    @GetMapping(ENVIO_EXITOSO)
    public ModelAndView paginaExitoso() {
        ModelAndView modelAndView = new ModelAndView("envios/envio-exitoso");

        return modelAndView;
    }
}