package py.com.domainsoft.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.seguridad.entities.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

    List<PerfilUsuarioEntity> findByUsuarioId(Integer idUsuario);
    
}
