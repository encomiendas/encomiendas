package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.seguridad.entities.UsuarioEntity;

/**
 * @author mcespedes
 */
public interface UsuarioRepository
        extends PagingAndSortingRepository<UsuarioEntity, Integer>  {
    UsuarioEntity findByLogin(String login);
}
