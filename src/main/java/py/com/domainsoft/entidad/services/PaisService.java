package py.com.domainsoft.entidad.services;

import java.util.List;

import py.com.domainsoft.entidad.dtos.PaisDTO;

public interface PaisService {

	PaisDTO grabarPais(PaisDTO pais);
	
	List<PaisDTO> findAll();

}
