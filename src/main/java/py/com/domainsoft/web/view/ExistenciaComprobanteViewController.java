package py.com.domainsoft.web.view;

import java.security.Principal;
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
import py.com.domainsoft.envios.dtos.ExistenciaComprobanteDTO;
import py.com.domainsoft.envios.services.EquipoService;
import py.com.domainsoft.envios.services.ExistenciaComprobanteService;
import py.com.domainsoft.envios.services.TipoComprobanteService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class ExistenciaComprobanteViewController extends BaseViewController {

    private static final String EXISTENCIA_COMPROBANTE_LISTA = "/existencia-comprobante-lista";
    private static final String EXISTENCIA_COMPROBANTE_EXITOSO = "/existencia-comprobante-exitoso";

    private final ExistenciaComprobanteService existenciaComprobanteService;
    private final TipoComprobanteService tipoComprobanteService;
    private final EquipoService equipoService;

    public ExistenciaComprobanteViewController(
            ExistenciaComprobanteService existenciaComprobanteService,
            TipoComprobanteService tipoComprobanteService,
            EquipoService equipoService) {

        this.existenciaComprobanteService = existenciaComprobanteService;
        this.tipoComprobanteService = tipoComprobanteService;
        this.equipoService = equipoService;

    }

    @GetMapping(EXISTENCIA_COMPROBANTE_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(
                "envios/existencia-comprobante");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina
                .orElse(Constantes.PEOPLE_INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<ExistenciaComprobanteDTO> listobj = existenciaComprobanteService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(listobj.getTotalPages(), listobj.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        modelAndView.addObject(Constantes.MENU_LIST,
                (List<MenuDTO>) session.getAttribute(Constantes.SESSION_MENU));
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA,
                (UserDetailsDTO) session
                        .getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios",
                (List<PerfilDTO>) session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles",
                (Integer) session.getAttribute("totalPerfiles"));

        // Datos
        modelAndView.addObject("existenciaComprobante",
                new ExistenciaComprobanteDTO());
        modelAndView.addObject("tiposComprobantes",
                tipoComprobanteService.findAll());
        modelAndView.addObject("equipos", equipoService.findAll());

        // Paginacion
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;

    }

    @PostMapping(value = EXISTENCIA_COMPROBANTE_LISTA)
    public ModelAndView createUpdateTipoImpuesto(
            @Valid ExistenciaComprobanteDTO comprobanteDTO,
            BindingResult bindingResult, Principal principal) {
        comprobanteDTO.setUsuario(
                new UsuarioDTO(getUsuarioDTO(principal).getIdUsuario()));
        System.out.println(comprobanteDTO.toString());
        existenciaComprobanteService
                .grabarExistenciaComprobante(comprobanteDTO);

        return new ModelAndView("redirect:" + EXISTENCIA_COMPROBANTE_EXITOSO);
    }

    @GetMapping(value = EXISTENCIA_COMPROBANTE_EXITOSO)
    public ModelAndView tipoImpuestoExitoso() {

        String htmlpadre = EXISTENCIA_COMPROBANTE_LISTA;
        String msgexitoso = "Se aplicaron exitosamento los datos de Existencia Comprobante";

        ModelAndView modelAndView = new ModelAndView(
                Constantes.MSG_EXITOSO_URL);
        modelAndView.addObject("htmlpadre", htmlpadre);
        modelAndView.addObject("msgexitoso", msgexitoso);

        return modelAndView;
    }

}
