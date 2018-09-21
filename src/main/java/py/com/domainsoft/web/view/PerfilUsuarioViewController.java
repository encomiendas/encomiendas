package py.com.domainsoft.web.view;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.PerfilUsuarioDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.services.MenuService;
import py.com.domainsoft.seguridad.services.PerfilService;
import py.com.domainsoft.seguridad.services.PerfilUsuarioService;
import py.com.domainsoft.seguridad.services.UsuarioService;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class PerfilUsuarioViewController extends BaseViewController {

    private final PerfilUsuarioService perfilUsuarioService;

    private final MenuService menuService;

    private final PerfilService perfilService;

    private final UsuarioService usuarioService;

    private static final String PERFILES = "/perfiles-usuario";

    private static final String PERFILES_LISTA = "/perfil-usuario-lista";

    public PerfilUsuarioViewController(
            PerfilUsuarioService perfilUsuarioService, MenuService menuService,
            PerfilService perfilService, UsuarioService usuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
        this.menuService = menuService;
        this.perfilService = perfilService;
        this.usuarioService = usuarioService;
    }

    /***
     * GET
     * 
     * @param model
     * @param principal
     * @return
     */
    @GetMapping(PERFILES_LISTA)
    public ModelAndView perfilUsuarioLista(Model model, Principal principal,
            HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(
                Constantes.PERFIL_USUARIO_LISTA_VIEW);

        modelAndView.addObject(Constantes.MENU_LIST,
                (List<MenuDTO>) session.getAttribute(Constantes.SESSION_MENU));

        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA,
                (UserDetailsDTO) session
                        .getAttribute(Constantes.SESSION_LOGIN_DATA));
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));

        modelAndView.addObject("listperfilesAll", perfilService.findAll());
        modelAndView.addObject("listusuariosAll", usuarioService.findAll());

        return modelAndView;
    }

    /***
     * GET
     * 
     * @param model
     * @param principal
     * @return
     */
    @GetMapping(PERFILES)
    public ModelAndView home(Model model, Principal principal) {

        ModelAndView modelAndView = new ModelAndView(
                Constantes.PERFIL_SELECCION_VIEW);

        /**
         * Inicializa el Objeto DTO del tag " th:object="${perfil}, Objeto que
         * se manejará en el POST
         */
        modelAndView.addObject(Constantes.PERFIL_OBJECT,
                new PerfilUsuarioDTO());

        /**
         * Esto muestra la lista de perfiles en tag select
         */
        modelAndView.addObject(Constantes.PERFILES_X_USUARIO,
                perfilUsuarioService.perfilesByUsuario(principal));

        return modelAndView;
    }

    /**
     * POST
     * 
     * @param model
     * @param perfilUsuario
     * @param principal
     * @param session
     * @return modelAndView
     */
    @PostMapping(PERFILES)
    public ModelAndView setPerfiles(Model model,
            @ModelAttribute("perfil_usuario") PerfilUsuarioDTO perfilUsuario,
            Principal principal, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(
                new RedirectView(Constantes.HOME_VIEW));

        List<MenuDTO> listaMenu = menuService
                .getMenuByPerfil(perfilUsuario.getPerfil().getIdPerfil());

        /**
         * Cuando se inicia session, se ingresa a un perfil, se guardan en la
         * memoria de session del usuario su menu y el UserDTO
         */
        List<PerfilDTO> listPerfilesUsuario = perfilUsuarioService
                .perfilesByUsuario(getUsuarioDTO(principal).getIdUsuario())
                .stream()
                .map(developer -> new PerfilDTO(
                        developer.getPerfil().getIdPerfil(),
                        developer.getPerfil().getDescripcion()))
                .collect(Collectors.toList());
        session.setAttribute(Constantes.SESSION_MENU, listaMenu);
        session.setAttribute(Constantes.SESSION_LOGIN_DATA, getUsuarioDTO(principal));
        session.setAttribute("perfilesUsuarios", listPerfilesUsuario);
        session.setAttribute("totalPerfiles", listPerfilesUsuario.size());

        modelAndView.addObject(Constantes.MENU_LIST, listaMenu);

        return modelAndView;
    }

}
