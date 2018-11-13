package py.com.domainsoft.envios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.TipoImpuestoDTO;
import py.com.domainsoft.envios.entities.TipoImpuestoEntity;

public interface TipoImpuestoService {
	

	public TipoImpuestoEntity grabarTipoImpuesto(TipoImpuestoDTO tipoImpuesto);
    
    public Page<TipoImpuestoDTO> findAllPageable(Pageable pageable);
    
    
    public List<TipoImpuestoDTO> findAll();

}
