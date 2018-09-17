package py.com.domainsoft.seguridad.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dtos.PerfilDTO;
import py.com.domainsoft.seguridad.entities.PerfilEntity;
import py.com.domainsoft.seguridad.mapper.PerfilMapper;
import py.com.domainsoft.seguridad.repositories.PerfilRepository;
import py.com.domainsoft.seguridad.services.PerfilService;

@Service
public class PerfilSeviceImpl implements PerfilService {

    private final PerfilRepository perfilRepo;

    private final PerfilMapper perfilMapper;

    public PerfilSeviceImpl(PerfilRepository perfilRepo,
            PerfilMapper perfilMapper) {
        this.perfilRepo = perfilRepo;
        this.perfilMapper = perfilMapper;
    }

    @Override
    public void grabarPerfil(PerfilDTO perfil) {
        perfilRepo.save(perfilMapper.dtoToEntity(perfil));
    }

    @Override
    public Page<PerfilDTO> findAllPageable(Pageable pageable) {
        Page<PerfilEntity> pageResponse = perfilRepo.findAll(pageable);
        return pageResponse.map(perfilMapper::entityToDto);
    }

}