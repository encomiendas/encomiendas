package py.com.domainsoft.envios.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.envios.entities.ConceptoEntity;

public interface ConceptoRepository  extends PagingAndSortingRepository<ConceptoEntity, Long>  {
	

    List<ConceptoEntity> findByGrupoConceptoIdGrupoConcepto(Integer IdGrupoConcepto);
}
