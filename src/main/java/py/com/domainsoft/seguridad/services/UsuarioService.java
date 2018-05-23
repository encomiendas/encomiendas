package py.com.domainsoft.seguridad.services;

import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

public interface UsuarioService {

    void grabarUsuario(UsuarioDTO usuario);
    
    UsuarioDTO findByLogin(String login);
    
}
