package py.com.domainsoft.seguridad.services;

import java.util.List;

import py.com.domainsoft.seguridad.dtos.PersonaDTO;
import py.com.domainsoft.seguridad.entities.PersonaEntity;

public interface PersonaService {

    List<PersonaDTO> findAll();
    
    PersonaEntity grabarPersona(PersonaDTO persona);
    
}
