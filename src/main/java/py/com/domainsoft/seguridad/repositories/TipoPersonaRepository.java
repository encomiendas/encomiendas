package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.seguridad.entities.TipoPersonaEntity;

public interface TipoPersonaRepository extends JpaRepository<TipoPersonaEntity, Integer> {

}
