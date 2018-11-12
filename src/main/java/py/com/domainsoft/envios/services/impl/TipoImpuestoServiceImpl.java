package py.com.domainsoft.envios.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.envios.dtos.TipoImpuestoDTO;
import py.com.domainsoft.envios.entities.TipoImpuestoEntity;
import py.com.domainsoft.envios.mapper.TipoImpuestoMapper;
import py.com.domainsoft.envios.repositories.TipoImpuestoRepository;
import py.com.domainsoft.envios.services.TipoImpuestoService;

@Service
public class TipoImpuestoServiceImpl implements TipoImpuestoService {
	
	
	private final TipoImpuestoRepository tipoImpuestoRepo;
    private final TipoImpuestoMapper tipoImpuestoMapper;

    public TipoImpuestoServiceImpl(TipoImpuestoRepository tipoImpuestoRepo,
            TipoImpuestoMapper tipoImpuestoMapper) {
        this.tipoImpuestoRepo = tipoImpuestoRepo;
        this.tipoImpuestoMapper = tipoImpuestoMapper;
    }


	@Override
	public TipoImpuestoEntity grabarTipoImpuesto(TipoImpuestoDTO tipoImpuesto) {
       
		tipoImpuesto.setDescripcion(tipoImpuesto.getDescripcion().toUpperCase());
		return tipoImpuestoRepo.save(tipoImpuestoMapper.dtoToEntity(tipoImpuesto));
	}

	@Override
	public Page<TipoImpuestoDTO> findAllPageable(Pageable pageable) {
		Page<TipoImpuestoEntity> pageResponse = tipoImpuestoRepo.findAll(pageable);
		return pageResponse.map(tipoImpuestoMapper::entityToDto);
	}
	
	
	@Override
    public List<TipoImpuestoDTO> findAll() {
        return tipoImpuestoMapper.entityListToDtoList(
                WebUtils.toList(tipoImpuestoRepo.findAll()));
    }

	
	

}
