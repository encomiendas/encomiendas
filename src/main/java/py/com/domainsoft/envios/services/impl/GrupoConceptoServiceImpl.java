package py.com.domainsoft.envios.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.envios.dtos.GrupoConceptoDTO;
import py.com.domainsoft.envios.entities.GrupoConceptoEntity;
import py.com.domainsoft.envios.mapper.GrupoConceptoMapper;
import py.com.domainsoft.envios.repositories.GrupoConceptoRepository;
import py.com.domainsoft.envios.services.GrupoConceptoService;

@Service
public class GrupoConceptoServiceImpl implements GrupoConceptoService {
	
	private final GrupoConceptoRepository grupoConceptoRepo;

	private final GrupoConceptoMapper grupoConceptoMapper;


	public GrupoConceptoServiceImpl(GrupoConceptoRepository grupoConceptoRepo,
	        GrupoConceptoMapper grupoConceptoMapper) {
	    
		this.grupoConceptoRepo = grupoConceptoRepo;
	    this.grupoConceptoMapper = grupoConceptoMapper;
	}

	@Override
	public Page<GrupoConceptoDTO> findAllPageable(Pageable pageable) {
		
		Page<GrupoConceptoEntity> pageResponse = grupoConceptoRepo.findAll(pageable);
        return pageResponse.map(grupoConceptoMapper::entityToDto);
	}

	@Override
	public void grabarGrupoConcepto(GrupoConceptoDTO grupoConcepto) {
		
		grupoConceptoRepo.save(grupoConceptoMapper.dtoToEntity(grupoConcepto));
		
	}

	

}
