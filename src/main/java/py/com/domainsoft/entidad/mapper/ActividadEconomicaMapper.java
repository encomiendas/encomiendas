package py.com.domainsoft.entidad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.entidad.dtos.ActividadEconomicaDTO;
import py.com.domainsoft.entidad.entities.ActividadEconomicaEntity;

/**
 * 
 * @author jdferreira
 *
 */
@Component
public class ActividadEconomicaMapper implements BaseMapper<ActividadEconomicaEntity, ActividadEconomicaDTO> {

	private final ModelMapper modelMapper;

	public ActividadEconomicaMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ActividadEconomicaDTO> entityListToDtoList(List<ActividadEconomicaEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public ActividadEconomicaDTO entityToDto(ActividadEconomicaEntity entity) {
	    ActividadEconomicaDTO dto = modelMapper.map(entity, ActividadEconomicaDTO.class);
		return dto;
	}

	@Override
	public ActividadEconomicaEntity dtoToEntity(ActividadEconomicaDTO dto) {
		return modelMapper.map(dto, ActividadEconomicaEntity.class);
	}

}
