package py.com.domainsoft.seguridad.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.domainsoft.seguridad.entities.PersonaEntity;

public interface PersonaRepository extends PagingAndSortingRepository<PersonaEntity, Long> {
    
    List<PersonaEntity> findAll();
    
    List<PersonaEntity> findByTipoDocumentoIdTipoDocumentoAndDocumento(Integer idTipoDocumento, String documento);
    
    List<PersonaEntity> findByNombresOrApellidosIgnoreCaseContaining(String nombres, String apellidos);
    
    List<PersonaEntity> findByNombresIgnoreCaseContaining(String nombres);
    
    List<PersonaEntity> findByApellidosIgnoreCaseContaining(String apellidos);
}
