package py.com.domainsoft.entidad.services.impl;

import org.springframework.stereotype.Service;

import py.com.domainsoft.entidad.dtos.EnvioDetDTO;
import py.com.domainsoft.entidad.mapper.EnvioDetMapper;
import py.com.domainsoft.entidad.repositories.EnvioDetRepository;
import py.com.domainsoft.entidad.services.EnvioDetService;

@Service
public class EnvioDetServiceImpl implements EnvioDetService{
    
    private EnvioDetMapper envioDetMapper;
    private EnvioDetRepository envioDetRepo;

    public EnvioDetServiceImpl(EnvioDetMapper envioDetMapper, EnvioDetRepository envioDetRepo) {
        this.envioDetMapper = envioDetMapper;
        this.envioDetRepo = envioDetRepo;
    }

    @Override
    public EnvioDetDTO grabarDetalleEnvio(EnvioDetDTO envioDetalle) {
        // TODO Auto-generated method stub
        return null;
    }

    

}
