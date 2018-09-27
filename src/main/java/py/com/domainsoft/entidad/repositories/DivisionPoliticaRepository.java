package py.com.domainsoft.entidad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.DivisionPoliticaEntity;

public interface DivisionPoliticaRepository extends JpaRepository<DivisionPoliticaEntity, Integer> {

    List<DivisionPoliticaEntity> findByPaisId(Integer idPais);
}
