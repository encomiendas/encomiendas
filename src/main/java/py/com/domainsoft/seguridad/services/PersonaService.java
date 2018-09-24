package py.com.domainsoft.seguridad.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.seguridad.dtos.PersonaDTO;
import py.com.domainsoft.seguridad.entities.PersonaEntity;

public interface PersonaService {

    List<PersonaDTO> findAll();
    
    PersonaEntity grabarPersona(PersonaDTO persona);
    
    Page<PersonaDTO> findAllPageable(Pageable pageable);
    
}
