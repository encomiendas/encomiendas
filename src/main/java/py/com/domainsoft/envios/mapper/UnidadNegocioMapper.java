package py.com.domainsoft.envios.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;
import py.com.domainsoft.envios.entities.UnidadNegocioEntity;

@Component
public class UnidadNegocioMapper implements BaseMapper<UnidadNegocioEntity, UnidadNegocioDTO> {

	private final ModelMapper modelMapper;

	public UnidadNegocioMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<UnidadNegocioDTO> entityListToDtoList(List<UnidadNegocioEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public UnidadNegocioEntity dtoToEntity(UnidadNegocioDTO dto) {
		return modelMapper.map(dto, UnidadNegocioEntity.class);
	}

	@Override
	public UnidadNegocioDTO entityToDto(UnidadNegocioEntity entity) {
		UnidadNegocioDTO dto = modelMapper.map(entity, UnidadNegocioDTO.class);
	    return dto;
	}

}
