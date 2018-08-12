package py.com.domainsoft.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.seguridad.dtos.PersonaDTO;
import py.com.domainsoft.seguridad.entities.PersonaEntity;

/**
 * @author mcespedes
 */
@Component
public class PersonaMapper implements BaseMapper<PersonaEntity, PersonaDTO> {

    private final ModelMapper modelMapper;

    public PersonaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    @Override
    public List<PersonaDTO> entityListToDtoList(
            List<PersonaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());        
    }

    @Override
    public PersonaDTO entityToDto(PersonaEntity entity) {
        PersonaDTO dto = modelMapper.map(entity, PersonaDTO.class);
        return dto;
    }

    @Override
    public PersonaEntity dtoToEntity(PersonaDTO dto) {
        return modelMapper.map(dto, PersonaEntity.class);
    }

    
    
}
