package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.seguridad.entities.TipoDocumentoEntity;
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer> {

}
