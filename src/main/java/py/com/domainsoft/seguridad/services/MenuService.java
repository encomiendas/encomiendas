package py.com.domainsoft.seguridad.services;

import java.util.List;

import py.com.domainsoft.seguridad.dtos.MenuDTO;

public interface MenuService {

    List<MenuDTO> getMenuByPerfil(Integer idPerfil);
    
}
