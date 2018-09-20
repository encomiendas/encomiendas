package py.com.domainsoft.seguridad.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.seguridad.dtos.PaginaDTO;

public interface PaginaService {
    
    void grabarPagina(PaginaDTO pagina);
    
    Page<PaginaDTO> findAllPageable(Pageable pageable);
    
    List<PaginaDTO> findAll();
    
}
