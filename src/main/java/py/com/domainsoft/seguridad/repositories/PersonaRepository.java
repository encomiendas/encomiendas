package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.seguridad.entities.PersonaEntity;

public interface PersonaRepository extends PagingAndSortingRepository<PersonaEntity, Long> {

}
