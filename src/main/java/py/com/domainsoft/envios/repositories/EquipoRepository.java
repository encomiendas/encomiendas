package py.com.domainsoft.envios.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.envios.entities.EquipoEntity;

public interface EquipoRepository
        extends PagingAndSortingRepository<EquipoEntity, Long> {

}
