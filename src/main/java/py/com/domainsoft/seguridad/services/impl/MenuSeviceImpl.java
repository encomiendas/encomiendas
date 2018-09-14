package py.com.domainsoft.seguridad.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.mapper.MenuMapper;
import py.com.domainsoft.seguridad.repositories.MenuRepository;
import py.com.domainsoft.seguridad.services.MenuService;

@Service
public class MenuSeviceImpl implements MenuService {
    
    private final MenuRepository menuRepo;
    
    private final MenuMapper menuMapper;

    public MenuSeviceImpl(MenuRepository menuRepo,
            MenuMapper menuMapper) {
        this.menuRepo = menuRepo;
        this.menuMapper = menuMapper;
    }
    
    @Override
    public List<MenuDTO> getMenuByPerfil(Integer idPerfil) {
        
        List<MenuDTO> menuPrincipal = menuMapper
                .entityListToDtoList(
                        menuRepo
                        .findByPerfilIdPerfilAndTipoMenu(idPerfil, "M"));
        menuPrincipal.forEach(item-> {
            item.setListSubMenu(menuMapper
                    .entityListToDtoList(menuRepo
                            .findByMenuAnteriorIdMenu(item.getIdMenu())));
        });
        return menuPrincipal;
    }

}
