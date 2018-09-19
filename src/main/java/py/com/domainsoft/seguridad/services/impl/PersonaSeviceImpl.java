package py.com.domainsoft.seguridad.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.seguridad.dtos.PersonaDTO;
import py.com.domainsoft.seguridad.mapper.PersonaMapper;
import py.com.domainsoft.seguridad.repositories.PersonaRepository;
import py.com.domainsoft.seguridad.services.PersonaService;

@Service
public class PersonaSeviceImpl implements PersonaService {
    
    private final PersonaRepository personaRepo;
    private final PersonaMapper personaMapper;
    
    
    public PersonaSeviceImpl(PersonaRepository personaRepo,
            PersonaMapper personaMapper) {
        this.personaRepo = personaRepo;
        this.personaMapper = personaMapper;
    }

    @Override
    public List<PersonaDTO> findAll() {
        return personaMapper.
                entityListToDtoList(WebUtils.
                        toList(personaRepo.findAll()));
    }

}
