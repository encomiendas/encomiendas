package py.com.domainsoft.web.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.com.domainsoft.seguridad.dtos.PersonaDTO;
import py.com.domainsoft.seguridad.services.PersonaService;

@RestController
@RequestMapping(value = "/api/v1/personas")
public class PersonaRestController {

    private final PersonaService personaService;

    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/find-by-params")
    public List<PersonaDTO> home(Principal principal,
            @RequestParam("persona") String persona) {
        return personaService.findPersonaByParams(persona);
    }

}
