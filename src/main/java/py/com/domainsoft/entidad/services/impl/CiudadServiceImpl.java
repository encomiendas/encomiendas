package py.com.domainsoft.entidad.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.entidad.dtos.CiudadDTO;
import py.com.domainsoft.entidad.mapper.CiudadMapper;
import py.com.domainsoft.entidad.repositories.CiudadRepository;
import py.com.domainsoft.entidad.services.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {

    private CiudadMapper ciudadMapper;
    private CiudadRepository ciudadRepo;

    public CiudadServiceImpl(CiudadMapper ciudadMapper,
            CiudadRepository ciudadRepo) {
        this.ciudadMapper = ciudadMapper;
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public List<CiudadDTO> findAll() {
        return ciudadMapper
                .entityListToDtoList(WebUtils.toList(ciudadRepo.findAll()));
    }

    @Override
    public List<CiudadDTO> findByDivisionPoliticaIdDivisionPolitica(
            Integer idDivisionPolitica) {
        return ciudadMapper.entityListToDtoList(WebUtils.toList(ciudadRepo
                .findByDivisionPoliticaIdDivisionPolitica(idDivisionPolitica)));
    }

}
