package py.com.domainsoft.envios.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.envios.dtos.TipoComprobanteDTO;
import py.com.domainsoft.envios.entities.TipoComprobanteEntity;

@Component
public class TipoComprobanteMapper
        implements BaseMapper<TipoComprobanteEntity, TipoComprobanteDTO> {

    private final ModelMapper modelMapper;

    public TipoComprobanteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoComprobanteDTO> entityListToDtoList(
            List<TipoComprobanteEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public TipoComprobanteDTO entityToDto(TipoComprobanteEntity entity) {
        TipoComprobanteDTO dto = modelMapper.map(entity,
                TipoComprobanteDTO.class);
        return dto;
    }

    @Override
    public TipoComprobanteEntity dtoToEntity(TipoComprobanteDTO dto) {
        return modelMapper.map(dto, TipoComprobanteEntity.class);
    }

}
