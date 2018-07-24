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
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;
import py.com.domainsoft.seguridad.services.UsuarioService;

@Controller
public class UsuarioViewController {

    private final UsuarioService usuarioService;

    public UsuarioViewController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario-lista")
    public ModelAndView usuarioLista(
            @RequestParam("pageSize") Optional<Integer> tamanhoPagina,
            @RequestParam("page") Optional<Integer> numeroPagina) {

        ModelAndView modelAndView = new ModelAndView("seguridad/usuario-lista");

        /**
         * Evalua si es null, y muestra por defecto
         */
        int evalPageSize = tamanhoPagina.orElse(Constantes.INITIAL_PAGE_SIZE);
        int evalPage = (numeroPagina.orElse(0) < 1) ? Constantes.INITIAL_PAGE
                : numeroPagina.get() - 1;

        Page<UsuarioDTO> persons = usuarioService
                .findAllPageable(PageRequest.of(evalPage, evalPageSize));

        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(),
                Constantes.BUTTONS_TO_SHOW);

        UsuarioDTO user = new UsuarioDTO();

        modelAndView.addObject("user", user);
        modelAndView.addObject("persons", persons);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", Constantes.PAGE_SIZES);
        modelAndView.addObject("pager", pager);

        return modelAndView;
    }

    @PostMapping(value = "/usuario-lista")
    public ModelAndView createNewUser(@Valid UsuarioDTO user,
            BindingResult bindingResult) {

        usuarioService.grabarUsuario(user);

        return new ModelAndView("redirect:/usuario-exitoso");
    }

    @GetMapping(value = "/usuario-exitoso")
    public ModelAndView usuarioExitoso() {
        ModelAndView modelAndView = new ModelAndView(
                "seguridad/usuario-exitoso");

        return modelAndView;
    }
}