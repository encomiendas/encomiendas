package py.com.domainsoft.web.view;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.seguridad.dtos.UsuarioDTO;
import py.com.domainsoft.seguridad.services.UsuarioService;

@Controller
public class UsuarioViewController {

    UsuarioService usuarioService;

    public UsuarioViewController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid UsuarioDTO user,
            BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        
        System.out.println("el usuario es: " + user.getLogin());        

        UsuarioDTO userExists = usuarioService.findByLogin(user.getLogin());

        if (userExists != null) {
            System.out.println("entro porque es != null");
            bindingResult.rejectValue("login", "error.user",
                    "Ya hay un usuario registrado con el login proporcionado");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("seguridad/perfilusuario");
        } else {
            usuarioService.grabarUsuario(user);
            modelAndView.addObject("successMessage",
                    "User has been registered successfully");
            modelAndView.addObject("user", new UsuarioDTO());
            modelAndView.setViewName("seguridad/perfilusuario");
        }
        return modelAndView;
    }

}
