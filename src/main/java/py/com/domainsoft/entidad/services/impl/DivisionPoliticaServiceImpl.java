package py.com.domainsoft.entidad.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.entidad.dtos.DivisionPoliticaDTO;
import py.com.domainsoft.entidad.mapper.DivisionPoliticaMapper;
import py.com.domainsoft.entidad.repositories.DivisionPoliticaRepository;
import py.com.domainsoft.entidad.services.DivisionPoliticaService;

@Service
public class DivisionPoliticaServiceImpl implements DivisionPoliticaService {

    private DivisionPoliticaMapper DivisionPoliticaMapper;
    private DivisionPoliticaRepository divisionPoliticaRepo;

    public DivisionPoliticaServiceImpl(
            DivisionPoliticaMapper DivisionPoliticaMapper,
            DivisionPoliticaRepository divisionPoliticaRepo) {
        this.DivisionPoliticaMapper = DivisionPoliticaMapper;
        this.divisionPoliticaRepo = divisionPoliticaRepo;
    }

    @Override
    public List<DivisionPoliticaDTO> findByPaisId(Integer idPais) {
        return DivisionPoliticaMapper.entityListToDtoList(
                WebUtils.toList(divisionPoliticaRepo.findByPaisId(idPais)));
    }

}
