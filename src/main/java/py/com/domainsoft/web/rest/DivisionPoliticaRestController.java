package py.com.domainsoft.web.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.domainsoft.entidad.dtos.DivisionPoliticaDTO;
import py.com.domainsoft.entidad.services.DivisionPoliticaService;
import py.com.domainsoft.web.base.BaseViewController;

@RestController
@RequestMapping(value = "/api/v1/division-politica")
public class DivisionPoliticaRestController extends BaseViewController {

    private final DivisionPoliticaService divisionPoliticaService;

    public DivisionPoliticaRestController(
            DivisionPoliticaService divisionPoliticaService) {
        this.divisionPoliticaService = divisionPoliticaService;
    }

    @GetMapping("/pais/{idPais}")
    public List<DivisionPoliticaDTO> home(Principal principal,
            @PathVariable("idPais") Integer idPais) {
        return divisionPoliticaService.findByPaisId(idPais);
    }
    
}
