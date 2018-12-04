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
import py.com.domainsoft.envios.dtos.TipoComprobanteDTO;
import py.com.domainsoft.envios.services.TipoComprobanteService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@Controller
public class TipoComprobanteViewController {

    private static final String TIPO_COMPROBANTE_LISTA = "/tipo-comprobante-lista";
    private static final String TIPO_COMPROBANTE_EXITOSO = "/tipo-comprobante-exitoso";

    private final TipoComprobanteService tipoComprobanteService;

    public TipoComprobanteViewController(
            TipoComprobanteService tipoComprobanteService) {

        this.tipoComprobanteService = tipoComprobanteService;

    }

    @GetMapping(TIPO_COMPROBANTE_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("envios/tipo-comprobante");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina
                .orElse(Constantes.PEOPLE_INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<TipoComprobanteDTO> listobj = tipoComprobanteService
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
        modelAndView.addObject("tipoComprobante", new TipoComprobanteDTO());

        // Paginacion
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;

    }

    @PostMapping(value = TIPO_COMPROBANTE_LISTA)
    public ModelAndView createUpdateTipoImpuesto(
            @Valid TipoComprobanteDTO comprobanteDTO,
            BindingResult bindingResult) {

        tipoComprobanteService.grabarTipoComprobante(comprobanteDTO);

        return new ModelAndView("redirect:" + TIPO_COMPROBANTE_EXITOSO);
    }

    @GetMapping(value = TIPO_COMPROBANTE_EXITOSO)
    public ModelAndView tipoImpuestoExitoso() {

        String htmlpadre = TIPO_COMPROBANTE_EXITOSO;
        String msgexitoso = "Se aplicaron exitosamento los datos de Tipo Comprobante";

        ModelAndView modelAndView = new ModelAndView(
                Constantes.MSG_EXITOSO_URL);
        modelAndView.addObject("htmlpadre", htmlpadre);
        modelAndView.addObject("msgexitoso", msgexitoso);

        return modelAndView;
    }

}
