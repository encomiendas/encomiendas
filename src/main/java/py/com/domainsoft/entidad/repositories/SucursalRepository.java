package py.com.domainsoft.entidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.SucursalEntity;

public interface SucursalRepository
        extends JpaRepository<SucursalEntity, Integer> {

}
