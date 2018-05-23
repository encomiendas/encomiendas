package py.com.domainsoft.web.view;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

@Controller
public class LoginViewController {
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/")
    public String index() {
        return "login";
    }
    
    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        
        UserDetailsDTO loginedUser = (UserDetailsDTO) ((Authentication) principal).getPrincipal();
        model.addAttribute("userInfo", loginedUser.getUsername());
        
        return "home";
    }
    
    @GetMapping("/perfil-usuario")
    public ModelAndView perfilUsuario(Model model, Principal principal) {
        
        UserDetailsDTO loginedUser = (UserDetailsDTO) ((Authentication) principal).getPrincipal();
        model.addAttribute("userInfo", loginedUser.getUsername());        
        //model.addAttribute("login", loginedUser);
        
        ModelAndView modelAndView = new ModelAndView();
        UsuarioDTO user = new UsuarioDTO();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("seguridad/perfilusuario");
        
        return modelAndView;
    }
    
    
    @GetMapping("/404")
    public String error404(Model model, Principal principal) {
        
        UserDetailsDTO loginedUser = (UserDetailsDTO) ((Authentication) principal).getPrincipal();
        model.addAttribute("userInfo", loginedUser.getUsername());
        
        return "error/404";
    }
    
    @GetMapping("/500")
    public String error500(Model model, Principal principal) {
        return "error/500";
    }
    
    @GetMapping("/react")
    public String react(Model model, Principal principal) {
        return "react/react";
    }
    
}
