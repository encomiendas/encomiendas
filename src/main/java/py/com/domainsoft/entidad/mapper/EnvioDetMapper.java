package py.com.domainsoft.entidad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.entidad.dtos.EnvioDetDTO;
import py.com.domainsoft.entidad.entities.EnvioDetEntity;

/**
 * 
 * @author jdferreira
 *
 */
@Component
public class EnvioDetMapper implements BaseMapper<EnvioDetEntity, EnvioDetDTO> {

	private final ModelMapper modelMapper;

	public EnvioDetMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<EnvioDetDTO> entityListToDtoList(List<EnvioDetEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public EnvioDetDTO entityToDto(EnvioDetEntity entity) {
	    EnvioDetDTO dto = modelMapper.map(entity, EnvioDetDTO.class);
		return dto;
	}

	@Override
	public EnvioDetEntity dtoToEntity(EnvioDetDTO dto) {
		return modelMapper.map(dto, EnvioDetEntity.class);
	}

}
