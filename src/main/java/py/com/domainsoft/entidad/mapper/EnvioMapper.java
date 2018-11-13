package py.com.domainsoft.entidad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.entidad.dtos.EnvioDTO;
import py.com.domainsoft.entidad.entities.EnvioEntity;

/**
 * 
 * @author jdferreira
 *
 */
@Component
public class EnvioMapper implements BaseMapper<EnvioEntity, EnvioDTO> {

	private final ModelMapper modelMapper;

	public EnvioMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<EnvioDTO> entityListToDtoList(List<EnvioEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public EnvioDTO entityToDto(EnvioEntity entity) {
	    EnvioDTO dto = modelMapper.map(entity, EnvioDTO.class);
		return dto;
	}

	@Override
	public EnvioEntity dtoToEntity(EnvioDTO dto) {
		return modelMapper.map(dto, EnvioEntity.class);
	}

}
