package py.com.domainsoft.envios.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.envios.dtos.EquipoDTO;
import py.com.domainsoft.envios.entities.EquipoEntity;
import py.com.domainsoft.envios.mapper.EquipoMapper;
import py.com.domainsoft.envios.repositories.EquipoRepository;
import py.com.domainsoft.envios.services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepo;
    private final EquipoMapper equipoMapper;

    public EquipoServiceImpl(EquipoRepository equipoRepo,
            EquipoMapper equipoMapper) {

        this.equipoRepo = equipoRepo;
        this.equipoMapper = equipoMapper;

    }

    @Override
    public EquipoEntity grabarEquipo(EquipoDTO equipo) {
        equipo.setDescripcion(equipo.getDescripcion().toUpperCase());
        return equipoRepo.save(equipoMapper.dtoToEntity(equipo));
    }

    @Override
    public Page<EquipoDTO> findAllPageable(Pageable pageable) {
        Page<EquipoEntity> pageResponse = equipoRepo.findAll(pageable);
        return pageResponse.map(equipoMapper::entityToDto);
    }

    @Override
    public List<EquipoDTO> findAll() {
        return equipoMapper
                .entityListToDtoList(WebUtils.toList(equipoRepo.findAll()));
    }

}
