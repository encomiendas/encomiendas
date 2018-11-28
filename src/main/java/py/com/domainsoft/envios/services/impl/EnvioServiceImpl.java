package py.com.domainsoft.envios.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import py.com.domainsoft.entidad.dtos.EnvioDTO;
import py.com.domainsoft.entidad.dtos.EnvioDetDTO;
import py.com.domainsoft.entidad.entities.EnvioEntity;
import py.com.domainsoft.entidad.mapper.EnvioDetMapper;
import py.com.domainsoft.entidad.mapper.EnvioMapper;
import py.com.domainsoft.envios.dtos.MonedaDTO;
import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;
import py.com.domainsoft.envios.repositories.EnvioDetRepository;
import py.com.domainsoft.envios.repositories.EnvioRepository;
import py.com.domainsoft.envios.services.EnvioService;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;
import py.com.domainsoft.seguridad.mapper.UsuarioMapper;

@Service
@Transactional
public class EnvioServiceImpl implements EnvioService {

    private EnvioMapper envioMapper;
    private EnvioRepository envioRepo;
    private EnvioDetMapper envioDetMapper;
    private EnvioDetRepository envioDetRepo;
    private UsuarioMapper usuarioMapper;

    public EnvioServiceImpl(EnvioMapper envioMapper, EnvioRepository envioRepo,
            EnvioDetMapper envioDetMapper, EnvioDetRepository envioDetRepo, UsuarioMapper usuarioMapper) {
        this.envioMapper = envioMapper;
        this.envioRepo = envioRepo;
        this.envioDetMapper = envioDetMapper;
        this.envioDetRepo = envioDetRepo;
        this.usuarioMapper = usuarioMapper;
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

    @Override
    public List<EnvioDTO> getByParams(String fechadesde, String fechahasta,
            String cliente) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm");

        if (cliente == null || cliente.equals("")) {
            return envioMapper
                    .entityListToDtoList(envioRepo
                            .findByFechaEnvioBetweenAndEstadoOrderByIdEnvioDesc(
                                    LocalDateTime.parse(fechadesde, formatter),
                                    LocalDateTime.parse(fechahasta, formatter),
                                    "P"))
                    .stream()
                    .peek(e -> e.setDetalles(envioDetMapper.entityListToDtoList(
                            envioDetRepo.findByIdEnvio(e.getIdEnvio()))))
                    .collect(Collectors.toList());

        } else {
            return envioMapper
                    .entityListToDtoList(envioRepo
                            .findByFechaEnvioBetweenAndEstadoOrderByIdEnvioDesc(
                                    LocalDateTime.parse(fechadesde, formatter),
                                    LocalDateTime.parse(fechahasta, formatter),
                                    "P"))
                    .stream()
                    .filter(e -> e.getClienteRemitente().getPersona()
                            .getNombres().toUpperCase()
                            .contains(cliente.toUpperCase())
                            || e.getClienteRemitente().getPersona()
                                    .getApellidos().toUpperCase()
                                    .contains(cliente.toUpperCase())
                            || e.getClienteRemitente().getPersona()
                                    .getDocumento().contains(cliente))
                    .peek(e -> e.setDetalles(envioDetMapper.entityListToDtoList(
                            envioDetRepo.findByIdEnvio(e.getIdEnvio()))))
                    .collect(Collectors.toList());

            // .forEach(e ->
            // e.setDetalles(envioDetMapper.entityListToDtoList(envioDetRepo.findByIdEnvio(e.getIdEnvio()))));

        }
    }

    @Override
    public String procesar(EnvioDTO envio, UserDetailsDTO user) {
        try {
            EnvioEntity entity = envioRepo.getOne(envio.getIdEnvio());
            System.out.println(entity.toString());
            entity.setEstado(envio.getEstado());
            entity.setEntregado(envio.getEntregado());
            // usuario
            UsuarioDTO u = new UsuarioDTO();
            u.setIdUsuario(user.getIdUsuario());
            u.setLogin(user.getUsername());
            entity.setUsuarioLog(usuarioMapper.dtoToEntity(u));

            envioRepo.save(entity);
            return "retonar el pdf";
        } catch (Exception e) {
           e.printStackTrace();
           throw e;
        }
        
    }

}
