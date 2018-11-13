package py.com.domainsoft.envios.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.MonedaDTO;

public interface MonedaService {

	public Page<MonedaDTO> findAllPageable(Pageable pageable);
	
	public void grabarMoneda(MonedaDTO moneda);
	
	
}
