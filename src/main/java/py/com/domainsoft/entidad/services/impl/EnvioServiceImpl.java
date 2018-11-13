package py.com.domainsoft.entidad.services.impl;

import org.springframework.stereotype.Service;

import py.com.domainsoft.entidad.dtos.EnvioDTO;
import py.com.domainsoft.entidad.mapper.EnvioMapper;
import py.com.domainsoft.entidad.repositories.EnvioRepository;
import py.com.domainsoft.entidad.services.EnvioService;

@Service
public class EnvioServiceImpl implements EnvioService{
    
    private EnvioMapper envioMapper;
    private EnvioRepository envioRepo;

    public EnvioServiceImpl(EnvioMapper envioMapper, EnvioRepository envioRepo) {
        this.envioMapper = envioMapper;
        this.envioRepo = envioRepo;
    }

    @Override
    public EnvioDTO grabarEnvio(EnvioDTO envio) {
        // TODO Auto-generated method stub
        return null;
    }

}
