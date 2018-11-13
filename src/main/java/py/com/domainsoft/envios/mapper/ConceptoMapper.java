package py.com.domainsoft.envios.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.envios.dtos.ConceptoDTO;
import py.com.domainsoft.envios.entities.ConceptoEntity;

@Component
public class ConceptoMapper implements BaseMapper<ConceptoEntity, ConceptoDTO> {
	
	private final ModelMapper modelMapper;

	public ConceptoMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ConceptoDTO> entityListToDtoList(List<ConceptoEntity> entityList) {
		return entityList.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());
	}
	

    @Override
    public ConceptoDTO entityToDto(ConceptoEntity entity) {
        ConceptoDTO dto = modelMapper.map(entity, ConceptoDTO.class);
        return dto;
    }

    @Override
    public ConceptoEntity dtoToEntity(ConceptoDTO dto) {
        return modelMapper.map(dto, ConceptoEntity.class);
    }


}
