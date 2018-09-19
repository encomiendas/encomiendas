package py.com.domainsoft.seguridad.services;

import java.security.Principal;
import java.util.List;

import py.com.domainsoft.seguridad.dtos.PerfilUsuarioDTO;

public interface PerfilUsuarioService {

    List<PerfilUsuarioDTO> perfilesByUsuario(Principal principal);
    
    List<PerfilUsuarioDTO> perfilesByUsuario(Integer idusuario);

    void grabarPerfilesPorUsuario(Integer idusuario, Integer[] perfiles);
    
}
