package py.com.domainsoft.entidad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.CiudadEntity;

public interface CiudadRepository extends JpaRepository<CiudadEntity, Integer> {

    List<CiudadEntity> findByDivisionPoliticaIdDivisionPolitica(Integer idDivisionPolitica);
    
}
