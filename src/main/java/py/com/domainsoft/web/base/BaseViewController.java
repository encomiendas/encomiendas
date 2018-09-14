package py.com.domainsoft.web.base;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

@Component
public class BaseViewController {
    
    public static UserDetailsDTO getUsuarioDTO(Principal principal){
        return (UserDetailsDTO) ((Authentication) principal).getPrincipal();
    }

}
