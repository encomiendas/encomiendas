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
import py.com.domainsoft.envios.dtos.EquipoDTO;
import py.com.domainsoft.envios.services.EquipoService;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@Controller
public class EquipoViewController {

    private static final String EQUIPO_LISTA = "/equipo-lista";
    private static final String EQUIPO_EXITOSO = "/equipo-exitoso";

    private final EquipoService equipoService;
    private final SucursalService sucursalService;

    public EquipoViewController(
            EquipoService equipoService,
            SucursalService sucursalService) {

        this.equipoService = equipoService;
        this.sucursalService = sucursalService;

    }

    @GetMapping(EQUIPO_LISTA)
    public ModelAndView paginaLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina,
            HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("envios/equipo");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina
                .orElse(Constantes.PEOPLE_INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<EquipoDTO> listobj = equipoService
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
        modelAndView.addObject("equipo", new EquipoDTO());
        modelAndView.addObject("sucursales", sucursalService.findAll());

        // Paginacion
        modelAndView.addObject("listobj", listobj);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;

    }

    @PostMapping(value = EQUIPO_LISTA)
    public ModelAndView createUpdateTipoImpuesto(
            @Valid EquipoDTO equipo,
            BindingResult bindingResult) {

        equipoService.grabarEquipo(equipo);

        return new ModelAndView("redirect:" + EQUIPO_EXITOSO);
    }

    @GetMapping(value = EQUIPO_EXITOSO)
    public ModelAndView tipoImpuestoExitoso() {

        String htmlpadre = EQUIPO_LISTA;
        String msgexitoso = "Se aplicaron exitosamento los datos del Equipo";

        ModelAndView modelAndView = new ModelAndView(
                Constantes.MSG_EXITOSO_URL);
        modelAndView.addObject("htmlpadre", htmlpadre);
        modelAndView.addObject("msgexitoso", msgexitoso);

        return modelAndView;
    }

}
