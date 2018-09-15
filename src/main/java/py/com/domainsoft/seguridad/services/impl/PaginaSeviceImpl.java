package py.com.domainsoft.seguridad.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dtos.PaginaDTO;
import py.com.domainsoft.seguridad.entities.PaginaEntity;
import py.com.domainsoft.seguridad.mapper.PaginaMapper;
import py.com.domainsoft.seguridad.repositories.PaginaRepository;
import py.com.domainsoft.seguridad.services.PaginaService;

@Service
public class PaginaSeviceImpl implements PaginaService {

    private final PaginaRepository paginaRepo;

    private final PaginaMapper paginaMapper;

    public PaginaSeviceImpl(PaginaRepository paginaRepo,
            PaginaMapper paginaMapper) {
        this.paginaRepo = paginaRepo;
        this.paginaMapper = paginaMapper;
    }

    @Override
    public void grabarPagina(PaginaDTO pagina) {
        paginaRepo.save(paginaMapper.dtoToEntity(pagina));
    }

    @Override
    public Page<PaginaDTO> findAllPageable(Pageable pageable) {
        Page<PaginaEntity> pageResponse = paginaRepo.findAll(pageable);
        return pageResponse.map(paginaMapper::entityToDto);
    }

}