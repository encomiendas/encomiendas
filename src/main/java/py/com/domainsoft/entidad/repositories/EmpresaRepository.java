package py.com.domainsoft.entidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.EmpresaEntity;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {

}
