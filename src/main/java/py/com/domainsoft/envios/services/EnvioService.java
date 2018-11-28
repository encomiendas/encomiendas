package py.com.domainsoft.envios.services;

import java.util.List;

import py.com.domainsoft.entidad.dtos.EnvioDTO;
import py.com.domainsoft.entidad.dtos.EnvioDetDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;

public interface EnvioService {

    EnvioDTO grabarEnvio(EnvioDTO envio, List<EnvioDetDTO> detalles,
            UserDetailsDTO user);

    String procesar(EnvioDTO envio, UserDetailsDTO user);

    List<EnvioDTO> getByParams(String fechadesde, String fechahasta,
            String cliente);

}
