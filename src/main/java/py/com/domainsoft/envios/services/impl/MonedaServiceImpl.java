package py.com.domainsoft.envios.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.envios.dtos.MonedaDTO;
import py.com.domainsoft.envios.entities.MonedaEntity;
import py.com.domainsoft.envios.mapper.MonedaMapper;
import py.com.domainsoft.envios.repositories.MonedaRepository;
import py.com.domainsoft.envios.services.MonedaService;

@Service
public class MonedaServiceImpl implements MonedaService {

	private final MonedaRepository monedaRepo;

	private final MonedaMapper monedaMapper;

	public MonedaServiceImpl(MonedaRepository monedaRepo, MonedaMapper monedaMapper) {

		this.monedaRepo = monedaRepo;
		this.monedaMapper = monedaMapper;

	}

	@Override
	public Page<MonedaDTO> findAllPageable(Pageable pageable) {
		Page<MonedaEntity> pageResponse = monedaRepo.findAll(pageable);
		return pageResponse.map(monedaMapper::entityToDto);
	}

	@Override
	public void grabarMoneda(MonedaDTO moneda) {
		moneda.setDescripcion(moneda.getDescripcion().toUpperCase());
		monedaRepo.save(monedaMapper.dtoToEntity(moneda));

	}
	
	@Override
	public List<MonedaDTO> findAll() {
		return monedaMapper.entityListToDtoList(WebUtils.toList(monedaRepo.findAll()));
	}

}
