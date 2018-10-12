package py.com.domainsoft.envios.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.envios.dtos.UnidadNegocioDTO;
import py.com.domainsoft.envios.entities.UnidadNegocioEntity;
import py.com.domainsoft.envios.mapper.UnidadNegocioMapper;
import py.com.domainsoft.envios.repositories.UnidadNegocioRepository;
import py.com.domainsoft.envios.services.UnidadNegocioService;

@Service
public class UnidadNegocioServiceImpl implements UnidadNegocioService {

	
	private final UnidadNegocioRepository unidadNegocioRepo;
	
	private final UnidadNegocioMapper unidadNegocioMapper;
	
	
	public UnidadNegocioServiceImpl(
			UnidadNegocioRepository unidadNegocioRepo,
			UnidadNegocioMapper unidadNegocioMapper) {
        
		this.unidadNegocioRepo = unidadNegocioRepo;
        this.unidadNegocioMapper = unidadNegocioMapper;
    }
	
	
	@Override
	public Page<UnidadNegocioDTO> findAllPageable(Pageable pageable) {
		Page<UnidadNegocioEntity> pageResponse = unidadNegocioRepo.findAll(pageable);
        return pageResponse.map(unidadNegocioMapper::entityToDto);
	}

	@Override
	public void grabarUnidadNegocio(UnidadNegocioDTO unidadNegocio) {
		
		unidadNegocioRepo.save(unidadNegocioMapper.dtoToEntity(unidadNegocio));
		
	}
	
	

}
