package py.com.domainsoft.entidad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.entidad.dtos.DivisionPoliticaDTO;
import py.com.domainsoft.entidad.entities.DivisionPoliticaEntity;

/**
 * 
 * @author jdferreira
 *
 */
@Component
public class DivisionPoliticaMapper implements BaseMapper<DivisionPoliticaEntity, DivisionPoliticaDTO> {

	private final ModelMapper modelMapper;

	public DivisionPoliticaMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<DivisionPoliticaDTO> entityListToDtoList(List<DivisionPoliticaEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public DivisionPoliticaDTO entityToDto(DivisionPoliticaEntity entity) {
	    DivisionPoliticaDTO dto = modelMapper.map(entity, DivisionPoliticaDTO.class);
		return dto;
	}

	@Override
	public DivisionPoliticaEntity dtoToEntity(DivisionPoliticaDTO dto) {
		return modelMapper.map(dto, DivisionPoliticaEntity.class);
	}

}
