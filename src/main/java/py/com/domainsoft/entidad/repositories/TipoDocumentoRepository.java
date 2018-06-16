package py.com.domainsoft.entidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer> {

}
