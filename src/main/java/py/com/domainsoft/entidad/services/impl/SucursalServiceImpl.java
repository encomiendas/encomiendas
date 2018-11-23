package py.com.domainsoft.entidad.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.entidad.dtos.SucursalDTO;
import py.com.domainsoft.entidad.mapper.SucursalMapper;
import py.com.domainsoft.entidad.repositories.SucursalRepository;
import py.com.domainsoft.entidad.services.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepo;
    private final SucursalMapper sucursalMapper;

    public SucursalServiceImpl(SucursalRepository sucursalRepo,
            SucursalMapper sucursalMapper) {
        this.sucursalRepo = sucursalRepo;
        this.sucursalMapper = sucursalMapper;
    }

    @Override
    public List<SucursalDTO> findAll() {
        return sucursalMapper
                .entityListToDtoList(WebUtils.
                        toList(sucursalRepo.findAll()));
    }
    
    @Override
    public SucursalDTO finById(Integer id) {
    	return sucursalMapper.entityToDto(sucursalRepo.findById(id).get());   
    } 

}
