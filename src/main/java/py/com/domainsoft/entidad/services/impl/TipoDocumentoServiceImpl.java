package py.com.domainsoft.entidad.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.domainsoft.entidad.dtos.TipoDocumentoDTO;
import py.com.domainsoft.entidad.mapper.TipoDocumentoMapper;
import py.com.domainsoft.entidad.repositories.TipoDocumentoRepository;
import py.com.domainsoft.entidad.services.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private TipoDocumentoMapper tipoDocumentoMapper;
	
	@Override
	public TipoDocumentoDTO grabarTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<TipoDocumentoDTO> tipoDocumentoAll(TipoDocumentoDTO tipoDocumento) {
		
		return tipoDocumentoMapper.entityListToDtoList(tipoDocumentoRepository.findAll());
		
	}

	
	
}
