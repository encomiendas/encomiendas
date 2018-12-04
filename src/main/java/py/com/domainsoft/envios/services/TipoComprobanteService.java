package py.com.domainsoft.envios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.TipoComprobanteDTO;
import py.com.domainsoft.envios.entities.TipoComprobanteEntity;

public interface TipoComprobanteService {

    public TipoComprobanteEntity grabarTipoComprobante(
            TipoComprobanteDTO tipoComprobante);

    public Page<TipoComprobanteDTO> findAllPageable(Pageable pageable);

    public List<TipoComprobanteDTO> findAll();

}
