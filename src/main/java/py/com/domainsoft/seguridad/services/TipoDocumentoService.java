package py.com.domainsoft.seguridad.services;

import java.util.List;

import py.com.domainsoft.seguridad.dtos.TipoDocumentoDTO;

public interface TipoDocumentoService {

	public TipoDocumentoDTO grabarTipoDocumento(TipoDocumentoDTO tipoDocumento);
	List<TipoDocumentoDTO> findAll();
}
