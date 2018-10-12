package py.com.domainsoft.envios.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;

public interface UnidadNegocioService {
	
	
	public Page<UnidadNegocioDTO> findAllPageable(Pageable pageable);
	
	public void grabarUnidadNegocio(UnidadNegocioDTO unidadNegocio);
	

}
