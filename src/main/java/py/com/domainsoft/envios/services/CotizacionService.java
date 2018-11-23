package py.com.domainsoft.envios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.CotizacionDTO;
import py.com.domainsoft.envios.entities.CotizacionEntity;

public interface CotizacionService {
	
	public CotizacionEntity grabarCotizacion(CotizacionDTO cotizacion);
    
    public Page<CotizacionDTO> findAllPageable(Pageable pageable);
    
    public List<CotizacionDTO> findAll();


}
