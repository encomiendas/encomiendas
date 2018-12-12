package py.com.domainsoft.envios.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.envios.dtos.ExistenciaComprobanteDTO;
import py.com.domainsoft.envios.entities.ExistenciaComprobanteEntity;
import py.com.domainsoft.envios.mapper.ExistenciaComprobanteMapper;
import py.com.domainsoft.envios.repositories.ExistenciaComprobanteRepository;
import py.com.domainsoft.envios.services.ExistenciaComprobanteService;

@Service
public class ExistenciaComprobanteServiceImpl
        implements ExistenciaComprobanteService {

    private final ExistenciaComprobanteRepository existenciaComprobanteRepo;
    private final ExistenciaComprobanteMapper existenciaComprobanteMapper;

    public ExistenciaComprobanteServiceImpl(
            ExistenciaComprobanteRepository existenciaComprobanteRepo,
            ExistenciaComprobanteMapper existenciaComprobanteMapper) {
        this.existenciaComprobanteRepo = existenciaComprobanteRepo;
        this.existenciaComprobanteMapper = existenciaComprobanteMapper;
    }

    @Override
    public Page<ExistenciaComprobanteDTO> findAllPageable(Pageable pageable) {
        Page<ExistenciaComprobanteEntity> pageResponse = existenciaComprobanteRepo
                .findAll(pageable);
        return pageResponse.map(existenciaComprobanteMapper::entityToDto);
    }

    @Override
    public List<ExistenciaComprobanteDTO> findAll() {
        return existenciaComprobanteMapper.entityListToDtoList(
                WebUtils.toList(existenciaComprobanteRepo.findAll()));
    }

    @Override
    public ExistenciaComprobanteEntity grabarExistenciaComprobante(
            ExistenciaComprobanteDTO existenciaComprobante) {

        return existenciaComprobanteRepo.save(
                existenciaComprobanteMapper.dtoToEntity(existenciaComprobante));
    }

}
