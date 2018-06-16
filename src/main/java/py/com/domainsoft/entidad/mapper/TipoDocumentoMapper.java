package py.com.domainsoft.entidad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.entidad.dtos.TipoDocumentoDTO;
import py.com.domainsoft.entidad.entities.TipoDocumentoEntity;

/**
 * 
 * @author lbareiro
 *
 */
@Component
public class TipoDocumentoMapper implements BaseMapper<TipoDocumentoEntity, TipoDocumentoDTO> {

	private final ModelMapper modelMapper;

	public TipoDocumentoMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<TipoDocumentoDTO> entityListToDtoList(List<TipoDocumentoEntity> entityList) {
		return entityList.stream()
				.filter(Objects::nonNull)
				.map(this::entityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public TipoDocumentoDTO entityToDto(TipoDocumentoEntity entity) {
		TipoDocumentoDTO dto = modelMapper.map(entity, TipoDocumentoDTO.class);
		return dto;
	}

	@Override
	public TipoDocumentoEntity dtoToEntity(TipoDocumentoDTO dto) {
		return modelMapper.map(dto, TipoDocumentoEntity.class);
	}

}
