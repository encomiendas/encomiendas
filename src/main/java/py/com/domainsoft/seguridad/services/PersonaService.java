package py.com.domainsoft.seguridad.services;

import java.util.List;

import py.com.domainsoft.seguridad.dtos.PersonaDTO;

public interface PersonaService {

    List<PersonaDTO> findAll();
    
}
