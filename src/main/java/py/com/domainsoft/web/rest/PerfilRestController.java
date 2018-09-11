package py.com.domainsoft.web.rest;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@RestController
@RequestMapping(value = "/api/v1/perfiles")
public class PerfilRestController {

    @GetMapping("/usuario")
    public String home(Model model, Principal principal) {
        
        UserDetailsDTO loginedUser = (UserDetailsDTO) ((Authentication) principal).getPrincipal();
        
        
        return "seguridad/perfil-seleccion";
    }
    
}
