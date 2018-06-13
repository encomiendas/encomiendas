package py.com.domainsoft.entidad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.entidad.dtos.PaisDTO;
import py.com.domainsoft.entidad.entities.PaisEntity;

/**
 * 
 * @author lbareiro
 *
 */
@Component
public class PaisMapper implements BaseMapper<PaisEntity, PaisDTO> {

	private final ModelMapper modelMapper;

	public PaisMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<PaisDTO> entityListToDtoList(List<PaisEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public PaisDTO entityToDto(PaisEntity entity) {
		PaisDTO dto = modelMapper.map(entity, PaisDTO.class);
		return dto;
	}

	@Override
	public PaisEntity dtoToEntity(PaisDTO dto) {
		return modelMapper.map(dto, PaisEntity.class);
	}

}
