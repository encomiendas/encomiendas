package py.com.domainsoft.entidad.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.entidad.dtos.EnvioDTO;
import py.com.domainsoft.entidad.dtos.EnvioDetDTO;
import py.com.domainsoft.entidad.entities.EnvioEntity;
import py.com.domainsoft.entidad.mapper.EnvioDetMapper;
import py.com.domainsoft.entidad.mapper.EnvioMapper;
import py.com.domainsoft.entidad.repositories.EnvioDetRepository;
import py.com.domainsoft.entidad.repositories.EnvioRepository;
import py.com.domainsoft.entidad.services.EnvioService;
import py.com.domainsoft.envios.dtos.MonedaDTO;
import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

@Service
public class EnvioServiceImpl implements EnvioService {

    private EnvioMapper envioMapper;
    private EnvioRepository envioRepo;
    private EnvioDetMapper envioDetMapper;
    private EnvioDetRepository envioDetRepo;

    public EnvioServiceImpl(EnvioMapper envioMapper, EnvioRepository envioRepo,
            EnvioDetMapper envioDetMapper, EnvioDetRepository envioDetRepo) {
        this.envioMapper = envioMapper;
        this.envioRepo = envioRepo;
        this.envioDetMapper = envioDetMapper;
        this.envioDetRepo = envioDetRepo;
    }

    @Override
    public EnvioDTO grabarEnvio(EnvioDTO envio, List<EnvioDetDTO> detalles,
            UserDetailsDTO user) {
        // TODO Auto-generated method stub
        UsuarioDTO u = new UsuarioDTO();
        u.setIdUsuario(user.getIdUsuario());
        u.setLogin(user.getUsername());
        envio.setUsuario(u);
        envio.setEntregado("N");
        envio.setFechaEnvio(LocalDateTime.now());
        UnidadNegocioDTO ne = new UnidadNegocioDTO();
        ne.setIdUnidadNegocio(2);
        envio.setUnidadNegocio(ne);
        // grabar cabecera
        EnvioEntity entity = envioRepo.save(envioMapper.dtoToEntity(envio));

        for (EnvioDetDTO det : detalles) {
            det.setIdEnvio(envio.getIdEnvio());
            det.setCantidad(new Double(1));
            det.setIdEnvio(entity.getIdEnvio());
            MonedaDTO m = new MonedaDTO();
            m.setIdMoneda(1);
            det.setMoneda(m);
            det.setMonedaEntrega(m);
            // grabar detalle
            envioDetRepo.save(envioDetMapper.dtoToEntity(det));

        }

        return envioMapper.entityToDto(entity);
    }

}
