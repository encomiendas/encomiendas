package py.com.domainsoft.entidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.EnvioEntity;

public interface EnvioRepository extends JpaRepository<EnvioEntity, Integer> {

}
