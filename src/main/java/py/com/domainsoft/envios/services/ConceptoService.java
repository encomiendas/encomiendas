package py.com.domainsoft.envios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.ConceptoDTO;
import py.com.domainsoft.envios.entities.ConceptoEntity;

public interface ConceptoService {

	public ConceptoEntity grabarConcepto(ConceptoDTO concepto);

	public Page<ConceptoDTO> findAllPageable(Pageable pageable);

	public List<ConceptoDTO> findAll();	
}
