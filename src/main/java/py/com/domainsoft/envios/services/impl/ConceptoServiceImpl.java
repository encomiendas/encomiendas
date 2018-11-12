package py.com.domainsoft.envios.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.envios.dtos.ConceptoDTO;
import py.com.domainsoft.envios.entities.ConceptoEntity;
import py.com.domainsoft.envios.mapper.ConceptoMapper;
import py.com.domainsoft.envios.repositories.ConceptoRepository;
import py.com.domainsoft.envios.services.ConceptoService;

@Service
public class ConceptoServiceImpl implements ConceptoService {
	
	private final ConceptoRepository conceptoRepo;
    private final ConceptoMapper conceptoMapper;
    
    
    public ConceptoServiceImpl (
    		  ConceptoRepository conceptoRepo,
    		  ConceptoMapper conceptoMapper) {
    	
    	this.conceptoMapper = conceptoMapper;
    	this.conceptoRepo = conceptoRepo;
    	
    }

	@Override
	public ConceptoEntity grabarConcepto(ConceptoDTO concepto) {
		concepto.setDescripcion(concepto.getDescripcion().toUpperCase());
		return conceptoRepo.save(conceptoMapper.dtoToEntity(concepto));
	}

	@Override
	public Page<ConceptoDTO> findAllPageable(Pageable pageable) {
		Page<ConceptoEntity> pageResponse = conceptoRepo.findAll(pageable);
		return pageResponse.map(conceptoMapper::entityToDto);
	}
	
	@Override
    public List<ConceptoDTO> findAll() {
        return conceptoMapper.entityListToDtoList(
                WebUtils.toList(conceptoRepo.findAll()));
    }

}
