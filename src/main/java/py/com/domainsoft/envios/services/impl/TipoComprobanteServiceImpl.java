package py.com.domainsoft.envios.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.envios.dtos.TipoComprobanteDTO;
import py.com.domainsoft.envios.entities.TipoComprobanteEntity;
import py.com.domainsoft.envios.mapper.TipoComprobanteMapper;
import py.com.domainsoft.envios.repositories.TipoComprobanteRepository;
import py.com.domainsoft.envios.services.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

    private final TipoComprobanteRepository tipoComprobanteRepo;
    private final TipoComprobanteMapper tipoComprobanteMapper;

    public TipoComprobanteServiceImpl(
            TipoComprobanteRepository tipoComprobanteRepo,
            TipoComprobanteMapper tipoComprobanteMapper) {
        this.tipoComprobanteRepo = tipoComprobanteRepo;
        this.tipoComprobanteMapper = tipoComprobanteMapper;
    }

    @Override
    public Page<TipoComprobanteDTO> findAllPageable(Pageable pageable) {
        Page<TipoComprobanteEntity> pageResponse = tipoComprobanteRepo
                .findAll(pageable);
        return pageResponse.map(tipoComprobanteMapper::entityToDto);
    }

    @Override
    public List<TipoComprobanteDTO> findAll() {
        return tipoComprobanteMapper.entityListToDtoList(
                WebUtils.toList(tipoComprobanteRepo.findAll()));
    }

    @Override
    public TipoComprobanteEntity grabarTipoComprobante(
            TipoComprobanteDTO tipoComprobante) {
        tipoComprobante
                .setDescripcion(tipoComprobante.getDescripcion().toUpperCase());
        return tipoComprobanteRepo
                .save(tipoComprobanteMapper.dtoToEntity(tipoComprobante));
    }

}
