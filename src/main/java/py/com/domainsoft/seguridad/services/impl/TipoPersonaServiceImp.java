package py.com.domainsoft.seguridad.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dtos.TipoPersonaDTO;
import py.com.domainsoft.seguridad.mapper.TipoPersonaMapper;
import py.com.domainsoft.seguridad.repositories.TipoPersonaRepository;
import py.com.domainsoft.seguridad.services.TipoPersonaService;

@Service
public class TipoPersonaServiceImp implements TipoPersonaService {

    @Autowired
    private TipoPersonaRepository tipoDocumentoRepository;
    
    @Autowired
    private TipoPersonaMapper tipoPersonaMapper;
    
    
    @Override
    public List<TipoPersonaDTO> findAll() {
        return tipoPersonaMapper.entityListToDtoList(tipoDocumentoRepository.findAll());
    }

}
