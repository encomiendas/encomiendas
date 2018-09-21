package py.com.domainsoft.seguridad.services;

import java.util.List;

import py.com.domainsoft.seguridad.dtos.TipoPersonaDTO;

public interface TipoPersonaService {

	List<TipoPersonaDTO> findAll();
}
