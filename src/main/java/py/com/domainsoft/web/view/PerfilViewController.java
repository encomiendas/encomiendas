package py.com.domainsoft.web.view;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.seguridad.dtos.PerfilUsuarioDTO;
import py.com.domainsoft.seguridad.services.PerfilUsuarioService;

@Controller
public class PerfilViewController {
    
    private final PerfilUsuarioService perfilUsuarioService;
    
    public PerfilViewController(PerfilUsuarioService perfilUsuarioService) {
        this.perfilUsuarioService=perfilUsuarioService;
    }

    @GetMapping("/perfiles")
    public ModelAndView home(Model model, Principal principal) {
        
        ModelAndView modelAndView = new ModelAndView("seguridad/perfil-seleccion");
        
        modelAndView.addObject("perfiles",  perfilUsuarioService.perfilesByUsuario(principal));
        modelAndView.addObject("perfil", new PerfilUsuarioDTO());
        
        return modelAndView;
    }
    
}
