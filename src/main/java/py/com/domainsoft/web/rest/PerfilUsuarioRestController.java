package py.com.domainsoft.web.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.com.domainsoft.seguridad.dtos.PerfilUsuarioDTO;
import py.com.domainsoft.seguridad.services.PerfilUsuarioService;
import py.com.domainsoft.web.base.BaseViewController;

@RestController
@RequestMapping(value = "/api/v1/perfil-usuarios")
public class PerfilUsuarioRestController extends BaseViewController {

    private final PerfilUsuarioService perfilUsuarioService;

    public PerfilUsuarioRestController(
            PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService = perfilUsuarioService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<PerfilUsuarioDTO> home(Principal principal,
            @RequestParam("idusuario") Integer idusuario) {
        return perfilUsuarioService.perfilesByUsuario(idusuario);
    }
    
    /**
     * POST
     * @param model
     * @param perfilUsuario
     * @param principal
     * @param session
     * @return modelAndView
     */
    @PostMapping()
    public void setGrabarPerfilUsuario(
            @RequestParam("idusuario") Integer idusuario,
            @RequestParam("perfiles[]") Integer[] perfiles,
            Principal principal) {
        
        perfilUsuarioService.grabarPerfilesPorUsuario(idusuario, perfiles);

        
    }

}
