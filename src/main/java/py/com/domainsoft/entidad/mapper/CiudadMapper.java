package py.com.domainsoft.entidad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.entidad.dtos.CiudadDTO;
import py.com.domainsoft.entidad.entities.CiudadEntity;

/**
 * 
 * @author jdferreira
 *
 */
@Component
public class CiudadMapper implements BaseMapper<CiudadEntity, CiudadDTO> {

	private final ModelMapper modelMapper;

	public CiudadMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<CiudadDTO> entityListToDtoList(List<CiudadEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public CiudadDTO entityToDto(CiudadEntity entity) {
	    CiudadDTO dto = modelMapper.map(entity, CiudadDTO.class);
		return dto;
	}

	@Override
	public CiudadEntity dtoToEntity(CiudadDTO dto) {
		return modelMapper.map(dto, CiudadEntity.class);
	}

}
