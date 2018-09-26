package py.com.domainsoft.seguridad.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.seguridad.dtos.PersonaDTO;
import py.com.domainsoft.seguridad.entities.PersonaEntity;
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

    @Override
    public PersonaEntity grabarPersona(PersonaDTO persona) {
        if(persona.getTipoDocumento2().getIdTipoDocumento() == null) persona.setTipoDocumento2(null);
        persona.setNombres(persona.getNombres().toUpperCase());
        persona.setApellidos(persona.getApellidos().toUpperCase());
        persona.setCorreo(persona.getCorreo().toUpperCase());
        persona.setDireccion(persona.getDireccion().toUpperCase());
        if(persona.getDocumento2().equals("")) persona.setDocumento2(null);
        return personaRepo.save(personaMapper.dtoToEntity(persona));
        
    }

    @Override
    public Page<PersonaDTO> findAllPageable(Pageable pageable) {
        Page<PersonaEntity> pageResponse = personaRepo.findAll(pageable);
        return pageResponse.map(personaMapper::entityToDto);
    }

}
