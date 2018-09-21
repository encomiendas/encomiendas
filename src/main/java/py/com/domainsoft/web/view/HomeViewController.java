package py.com.domainsoft.web.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class HomeViewController extends BaseViewController {
    
    public static final String HOME = "/home";

    @GetMapping(HOME)
    public ModelAndView home(HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView(Constantes.HOME_VIEW);
        modelAndView.addObject(Constantes.MENU_LIST, (List<MenuDTO>) session.getAttribute(Constantes.SESSION_MENU));        
        modelAndView.addObject(Constantes.SESSION_LOGIN_DATA, (UserDetailsDTO)session.getAttribute(Constantes.SESSION_LOGIN_DATA));        
        modelAndView.addObject("perfilesUsuarios", (List<PerfilDTO>)session.getAttribute("perfilesUsuarios"));
        modelAndView.addObject("totalPerfiles", (Integer)session.getAttribute("totalPerfiles"));
        
        return modelAndView;
    }
}
