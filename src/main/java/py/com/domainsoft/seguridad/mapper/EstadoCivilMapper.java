package py.com.domainsoft.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.seguridad.dtos.EstadoCivilDTO;
import py.com.domainsoft.seguridad.entities.EstadoCivilEntity;

/**
 * @author mcespedes
 */
@Component
public class EstadoCivilMapper
        implements BaseMapper<EstadoCivilEntity, EstadoCivilDTO> {

    private final ModelMapper modelMapper;

    public EstadoCivilMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EstadoCivilDTO> entityListToDtoList(
            List<EstadoCivilEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public EstadoCivilDTO entityToDto(EstadoCivilEntity entity) {
        EstadoCivilDTO dto = modelMapper.map(entity, EstadoCivilDTO.class);
        return dto;
    }

    @Override
    public EstadoCivilEntity dtoToEntity(EstadoCivilDTO dto) {
        return modelMapper.map(dto, EstadoCivilEntity.class);
    }

}
