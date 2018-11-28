package py.com.domainsoft.envios.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.EnvioEntity;

public interface EnvioRepository extends JpaRepository<EnvioEntity, Integer> {

    List<EnvioEntity> findByFechaEnvioBetweenAndEstadoOrderByIdEnvioDesc(LocalDateTime start, LocalDateTime end, String estado);
    
 
}
