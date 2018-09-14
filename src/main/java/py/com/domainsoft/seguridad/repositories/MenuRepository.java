package py.com.domainsoft.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.seguridad.entities.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    List<MenuEntity> findByPerfilIdPerfilAndTipoMenu(Integer idPerfil, String tipoMenu);
    
    List<MenuEntity> findByMenuAnteriorIdMenu(Integer idMenu);

}