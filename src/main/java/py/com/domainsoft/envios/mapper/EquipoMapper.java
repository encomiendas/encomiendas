package py.com.domainsoft.envios.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.envios.dtos.EquipoDTO;
import py.com.domainsoft.envios.entities.EquipoEntity;

@Component
public class EquipoMapper implements BaseMapper<EquipoEntity, EquipoDTO> {

    private final ModelMapper modelMapper;

    public EquipoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EquipoDTO> entityListToDtoList(List<EquipoEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public EquipoDTO entityToDto(EquipoEntity entity) {
        EquipoDTO dto = modelMapper.map(entity, EquipoDTO.class);
        return dto;
    }

    @Override
    public EquipoEntity dtoToEntity(EquipoDTO dto) {
        return modelMapper.map(dto, EquipoEntity.class);
    }

}
