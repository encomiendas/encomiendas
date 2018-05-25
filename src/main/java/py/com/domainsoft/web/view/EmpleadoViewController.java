package py.com.domainsoft.web.view;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@Controller
public class EmpleadoViewController {

    @GetMapping("/empleado")
    public String home(Model model, Principal principal) {
        
        UserDetailsDTO loginedUser = (UserDetailsDTO) ((Authentication) principal).getPrincipal();
        model.addAttribute("userInfo", loginedUser.getUsername());
        
        return "seguridad/empleado";
    }
    
}
