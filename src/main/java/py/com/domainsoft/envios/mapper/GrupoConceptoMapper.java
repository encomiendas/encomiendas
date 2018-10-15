package py.com.domainsoft.envios.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.envios.dtos.GrupoConceptoDTO;
import py.com.domainsoft.envios.entities.GrupoConceptoEntity;


	@Component
	public class GrupoConceptoMapper implements BaseMapper<GrupoConceptoEntity, GrupoConceptoDTO> {

	    private final ModelMapper modelMapper;

	    public GrupoConceptoMapper(ModelMapper modelMapper) {
	        this.modelMapper = modelMapper;
	    }

	    @Override
	    public List<GrupoConceptoDTO> entityListToDtoList(List<GrupoConceptoEntity> entityList) {
	        return entityList.stream().filter(Objects::nonNull)
	                .map(this::entityToDto).collect(Collectors.toList());
	    }

	    @Override
	    public GrupoConceptoDTO entityToDto(GrupoConceptoEntity entity) {
	    	GrupoConceptoDTO dto = modelMapper.map(entity, GrupoConceptoDTO.class);
	        return dto;
	    }

	    @Override
	    public GrupoConceptoEntity dtoToEntity(GrupoConceptoDTO dto) {
	        return modelMapper.map(dto, GrupoConceptoEntity.class);
	    }	
	

}
