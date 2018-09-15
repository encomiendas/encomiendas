package py.com.domainsoft.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.seguridad.dtos.PaginaDTO;
import py.com.domainsoft.seguridad.entities.PaginaEntity;

/**
 * @author mcespedes
 */
@Component
public class PaginaMapper implements BaseMapper<PaginaEntity, PaginaDTO> {

    private final ModelMapper modelMapper;

    public PaginaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PaginaDTO> entityListToDtoList(List<PaginaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public PaginaDTO entityToDto(PaginaEntity pagina) {
        PaginaDTO dto = modelMapper.map(pagina, PaginaDTO.class);
        return dto;
    }

    @Override
    public PaginaEntity dtoToEntity(PaginaDTO pagina) {
        return modelMapper.map(pagina, PaginaEntity.class);
    }

}
