package py.com.domainsoft.envios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.envios.dtos.EquipoDTO;
import py.com.domainsoft.envios.entities.EquipoEntity;

public interface EquipoService {

    public EquipoEntity grabarEquipo(EquipoDTO equipo);

    public Page<EquipoDTO> findAllPageable(Pageable pageable);

    public List<EquipoDTO> findAll();

}
