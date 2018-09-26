package py.com.domainsoft.entidad.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.entidad.dtos.ActividadEconomicaDTO;
import py.com.domainsoft.entidad.mapper.ActividadEconomicaMapper;
import py.com.domainsoft.entidad.repositories.ActividadEconomicaRepository;
import py.com.domainsoft.entidad.services.ActividadEconomicaService;

/**
 * @author jaime
 *
 */
@Service
public class ActividadEconomicaServiceImpl
        implements ActividadEconomicaService {

    private ActividadEconomicaRepository ActividadEconomicaRepo;
    private ActividadEconomicaMapper ActividadEconomicaMapper;

    public ActividadEconomicaServiceImpl(
            ActividadEconomicaRepository ActividadEconomicaRepo,
            ActividadEconomicaMapper actividadEconomicaMapper) {

        this.ActividadEconomicaRepo = ActividadEconomicaRepo;
        this.ActividadEconomicaMapper = actividadEconomicaMapper;
    }

    @Override
    public List<ActividadEconomicaDTO> findAll() {
        return ActividadEconomicaMapper.entityListToDtoList(
                WebUtils.toList(ActividadEconomicaRepo.findAll()));
    }

}
