package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.seguridad.entities.UsuarioRoleEntity;

public interface UsuarioRoleRepository  extends JpaRepository<UsuarioRoleEntity, Integer> {
    
}
