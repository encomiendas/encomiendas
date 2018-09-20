package py.com.domainsoft.seguridad.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.seguridad.dtos.MenuDTO;

public interface MenuService {

    List<MenuDTO> getMenuByPerfil(Integer idPerfil);
    
    Page<MenuDTO> findAllPageable(Pageable pageable);

    void grabarMenu(MenuDTO menu);

    List<MenuDTO> findAll();
    
}
