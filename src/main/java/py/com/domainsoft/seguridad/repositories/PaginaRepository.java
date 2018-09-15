package py.com.domainsoft.seguridad.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.seguridad.entities.PaginaEntity;

public interface PaginaRepository
        extends PagingAndSortingRepository<PaginaEntity, Long> {

}
