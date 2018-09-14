package py.com.domainsoft.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import py.com.domainsoft.web.base.BaseViewController;

@Controller
public class ErrorViewController extends BaseViewController {

    @GetMapping("/404")
    public String error404(Model model) {

        return "error/404";
    }

    @GetMapping("/500")
    public String error500(Model model) {
        return "error/500";
    }

    @GetMapping("/400")
    public String error400(Model model) {
        return "error/400";
    }

}
