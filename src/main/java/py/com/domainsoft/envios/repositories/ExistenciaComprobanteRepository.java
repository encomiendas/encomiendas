package py.com.domainsoft.envios.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.envios.entities.ExistenciaComprobanteEntity;

public interface ExistenciaComprobanteRepository
        extends PagingAndSortingRepository<ExistenciaComprobanteEntity, Long> {

}
