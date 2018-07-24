package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.seguridad.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
