package py.com.domainsoft.envios.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.envios.entities.TipoComprobanteEntity;

public interface TipoComprobanteRepository
        extends PagingAndSortingRepository<TipoComprobanteEntity, Long> {

}
