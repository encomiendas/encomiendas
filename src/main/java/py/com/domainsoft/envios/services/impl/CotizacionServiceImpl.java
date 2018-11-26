package py.com.domainsoft.envios.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.envios.dtos.CotizacionDTO;
import py.com.domainsoft.envios.entities.CotizacionEntity;
import py.com.domainsoft.envios.mapper.CotizacionMapper;
import py.com.domainsoft.envios.repositories.CotizacionRepository;
import py.com.domainsoft.envios.services.CotizacionService;

@Service
public class CotizacionServiceImpl implements CotizacionService {
	
	private final CotizacionRepository cotizacionRepo;
    private final CotizacionMapper cotizacionMapper;
    
    public CotizacionServiceImpl(CotizacionRepository cotizacionRepo,
            CotizacionMapper cotizacionMapper) {
    	
    	this.cotizacionRepo = cotizacionRepo;
        this.cotizacionMapper = cotizacionMapper;
    	
    }

	@Override
	public CotizacionEntity grabarCotizacion(CotizacionDTO cotizacion) {
		return cotizacionRepo.save(cotizacionMapper.dtoToEntity(cotizacion));
	}

	@Override
	public Page<CotizacionDTO> findAllPageable(Pageable pageable) {
		Page<CotizacionEntity> pageResponse = cotizacionRepo.findAll(pageable);
		return pageResponse.map(cotizacionMapper::entityToDto);
	}

	@Override
	public List<CotizacionDTO> findAll() {
		return cotizacionMapper.entityListToDtoList(
                WebUtils.toList(cotizacionRepo.findAll()));
	}

	
	

}
