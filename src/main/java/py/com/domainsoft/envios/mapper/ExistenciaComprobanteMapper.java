package py.com.domainsoft.envios.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.envios.dtos.ExistenciaComprobanteDTO;
import py.com.domainsoft.envios.entities.ExistenciaComprobanteEntity;

@Component
public class ExistenciaComprobanteMapper implements
        BaseMapper<ExistenciaComprobanteEntity, ExistenciaComprobanteDTO> {

    private final ModelMapper modelMapper;

    public ExistenciaComprobanteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ExistenciaComprobanteDTO> entityListToDtoList(
            List<ExistenciaComprobanteEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ExistenciaComprobanteDTO entityToDto(
            ExistenciaComprobanteEntity entity) {
        ExistenciaComprobanteDTO dto = modelMapper.map(entity,
                ExistenciaComprobanteDTO.class);
        return dto;
    }

    @Override
    public ExistenciaComprobanteEntity dtoToEntity(
            ExistenciaComprobanteDTO dto) {
        return modelMapper.map(dto, ExistenciaComprobanteEntity.class);
    }

}
