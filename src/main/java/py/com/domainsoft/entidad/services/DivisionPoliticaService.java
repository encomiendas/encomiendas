package py.com.domainsoft.entidad.services;

import java.util.List;

import py.com.domainsoft.entidad.dtos.DivisionPoliticaDTO;

public interface DivisionPoliticaService {

	List<DivisionPoliticaDTO> findByPaisId(Integer idPais);
	
}
