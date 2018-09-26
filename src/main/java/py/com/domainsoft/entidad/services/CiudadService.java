package py.com.domainsoft.entidad.services;

import java.util.List;

import py.com.domainsoft.entidad.dtos.CiudadDTO;

public interface CiudadService {

	List<CiudadDTO> findAll();
	List<CiudadDTO> findByDivisionPoliticaIdDivisionPolitica(Integer idDivisionPolitica);
	
}
