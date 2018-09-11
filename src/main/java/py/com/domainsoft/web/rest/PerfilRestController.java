package py.com.domainsoft.web.rest;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/perfiles")
public class PerfilRestController {

    @GetMapping("/usuario")
    public String home(Model model, Principal principal) {
        return "seguridad/perfil-seleccion";
    }
    
}
