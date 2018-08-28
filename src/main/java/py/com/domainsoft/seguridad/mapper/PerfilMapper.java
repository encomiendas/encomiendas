package py.com.domainsoft.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.entities.PerfilEntity;

/**
 * @author mcespedes
 */
@Component
public class PerfilMapper implements BaseMapper<PerfilEntity, PerfilDTO> {

    private final ModelMapper modelMapper;

    public PerfilMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PerfilDTO> entityListToDtoList(List<PerfilEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public PerfilDTO entityToDto(PerfilEntity entity) {
        PerfilDTO dto = modelMapper.map(entity, PerfilDTO.class);
        return dto;
    }

    @Override
    public PerfilEntity dtoToEntity(PerfilDTO dto) {
        return modelMapper.map(dto, PerfilEntity.class);
    }

}
