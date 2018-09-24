package py.com.domainsoft.seguridad.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.seguridad.dtos.MenuDTO;
import py.com.domainsoft.seguridad.entities.MenuEntity;
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

    @Override
    public Page<MenuDTO> findAllPageable(Pageable pageable) {
        Page<MenuEntity> pageResponse = menuRepo.findAll(pageable);
        return pageResponse.map(menuMapper::entityToDto);
    }

    @Override
    public void grabarMenu(MenuDTO menu) {
        if (menu.getTipoMenu().equals("M")) {
            menu.setPagina(null);
            menu.setMenuAnterior(null);
        }
        menuRepo.save(menuMapper.dtoToEntity(menu));
    }

    @Override
    public List<MenuDTO> findAll() {
        return menuMapper.entityListToDtoList(WebUtils.toList(menuRepo.findAll()));
    }

}
