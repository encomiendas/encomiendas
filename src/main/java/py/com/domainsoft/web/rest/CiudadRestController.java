package py.com.domainsoft.web.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.domainsoft.entidad.dtos.CiudadDTO;
import py.com.domainsoft.entidad.services.CiudadService;
import py.com.domainsoft.web.base.BaseViewController;

@RestController
@RequestMapping(value = "/api/v1/ciudad")
public class CiudadRestController extends BaseViewController {

    private final CiudadService ciudadService;

    public CiudadRestController(
            CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping("/division-politica/{idDivisionPolitica}")
    public List<CiudadDTO> home(Principal principal,
            @PathVariable("idDivisionPolitica") Integer idDivisionPolitica) {
        return ciudadService.findByDivisionPoliticaIdDivisionPolitica(idDivisionPolitica);
    }
    
}
