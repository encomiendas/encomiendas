package py.com.domainsoft.entidad.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.domainsoft.entidad.dtos.ClienteDTO;

public interface ClienteService {
    
    Page<ClienteDTO> findAllPageable(Pageable pageable);

    void grabarCliente(ClienteDTO cliente);

    List<ClienteDTO> findAll();
    
    ClienteDTO findByIdCliente(Integer idCliente);
    
}
