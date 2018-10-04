/**
 * 
 */
package py.com.domainsoft.entidad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.ClienteEntity;

/**
 * @author jaime
 *
 */
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

    List<ClienteEntity> findByIdCliente(Integer idCliente);
    
    
    List<ClienteEntity> findByPersonaTipoDocumentoIdTipoDocumentoAndPersonaDocumento(Integer idTipoDocumento, String documento);
    
    List<ClienteEntity> findByPersonaNombresOrPersonaApellidosIgnoreCaseContaining(String nombres, String apellidos);
    
    List<ClienteEntity> findByPersonaNombresIgnoreCaseContaining(String nombres);
    
    List<ClienteEntity> findByPersonaApellidosIgnoreCaseContaining(String apellidos);

}
