package py.com.domainsoft.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class LoginViewController extends BaseViewController {
    
    public static final String LOGIN = "/login";
    public static final String LOGIN_ROOT = "/";
    
    @GetMapping(LOGIN)
    public String login() {
        return "login";
    }
    
    @GetMapping(LOGIN_ROOT)
    public String index() {
        return "login";
    }
    
}
