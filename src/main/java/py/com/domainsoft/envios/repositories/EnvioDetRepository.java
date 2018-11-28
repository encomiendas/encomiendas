package py.com.domainsoft.envios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.domainsoft.entidad.entities.EnvioDetEntity;

public interface EnvioDetRepository extends JpaRepository<EnvioDetEntity, Integer> {

    List<EnvioDetEntity> findByIdEnvio(Integer idEnvio);
}
