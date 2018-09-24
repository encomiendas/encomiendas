package py.com.domainsoft.seguridad.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.seguridad.dtos.PerfilDTO;

public interface PerfilService {
    
    void grabarPerfil(PerfilDTO pagina);
    
    Page<PerfilDTO> findAllPageable(Pageable pageable);
    
    List<PerfilDTO> findAll();
    
}
