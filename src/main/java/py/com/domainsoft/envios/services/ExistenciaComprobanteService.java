package py.com.domainsoft.envios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.ExistenciaComprobanteDTO;
import py.com.domainsoft.envios.entities.ExistenciaComprobanteEntity;

public interface ExistenciaComprobanteService {

    public ExistenciaComprobanteEntity grabarExistenciaComprobante(
            ExistenciaComprobanteDTO existenciaComprobante);

    public Page<ExistenciaComprobanteDTO> findAllPageable(Pageable pageable);

    public List<ExistenciaComprobanteDTO> findAll();

}
