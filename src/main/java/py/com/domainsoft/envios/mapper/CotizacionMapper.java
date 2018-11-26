package py.com.domainsoft.envios.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.domainsoft.common.BaseMapper;
import py.com.domainsoft.envios.dtos.CotizacionDTO;
import py.com.domainsoft.envios.entities.CotizacionEntity;

@Component
public class CotizacionMapper implements BaseMapper<CotizacionEntity, CotizacionDTO> {
	
	private final ModelMapper modelMapper;

	public CotizacionMapper(ModelMapper modelMapper) {
	        this.modelMapper = modelMapper;
	    }
	
	@Override
    public List<CotizacionDTO> entityListToDtoList(
            List<CotizacionEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());        
    }

    @Override
    public CotizacionDTO entityToDto(CotizacionEntity entity) {
    	CotizacionDTO dto = modelMapper.map(entity, CotizacionDTO.class);
        return dto;
    }

    @Override
    public CotizacionEntity dtoToEntity(CotizacionDTO dto) {
        return modelMapper.map(dto, CotizacionEntity.class);
    }


}
