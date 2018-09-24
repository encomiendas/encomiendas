package py.com.domainsoft.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.seguridad.dtos.TipoPersonaDTO;
import py.com.domainsoft.seguridad.entities.TipoPersonaEntity;

/**
 * @author mcespedes
 */
@Component
public class TipoPersonaMapper
        implements BaseMapper<TipoPersonaEntity, TipoPersonaDTO> {

    private final ModelMapper modelMapper;

    public TipoPersonaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoPersonaDTO> entityListToDtoList(
            List<TipoPersonaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public TipoPersonaDTO entityToDto(TipoPersonaEntity entity) {
        TipoPersonaDTO dto = modelMapper.map(entity, TipoPersonaDTO.class);
        return dto;
    }

    @Override
    public TipoPersonaEntity dtoToEntity(TipoPersonaDTO dto) {
        return modelMapper.map(dto, TipoPersonaEntity.class);
    }

}
