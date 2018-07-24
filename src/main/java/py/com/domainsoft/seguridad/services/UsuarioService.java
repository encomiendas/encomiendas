package py.com.domainsoft.seguridad.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.seguridad.dtos.UsuarioDTO;

public interface UsuarioService {

    void grabarUsuario(UsuarioDTO usuario);
    
    UsuarioDTO findByLogin(String login);
    
    Page<UsuarioDTO> findAllPageable(Pageable pageable);
    
}
