package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.seguridad.entities.UsuarioEntity;

/**
 * @author mcespedes
 */
public interface UsuarioRepository
        extends JpaRepository<UsuarioEntity, Integer> {
    UsuarioEntity findByLogin(String login);
}
