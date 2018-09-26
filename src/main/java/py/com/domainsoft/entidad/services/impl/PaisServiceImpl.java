package py.com.domainsoft.entidad.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import py.com.domainsoft.common.WebUtils;
import py.com.domainsoft.entidad.dtos.PaisDTO;
import py.com.domainsoft.entidad.mapper.PaisMapper;
import py.com.domainsoft.entidad.repositories.PaisRepository;
import py.com.domainsoft.entidad.services.PaisService;

@Service
public class PaisServiceImpl implements PaisService {

    private PaisMapper paisMapper;
    private PaisRepository paisRepo;

    public PaisServiceImpl(PaisMapper paisMapper, PaisRepository paisRepo) {
        this.paisMapper = paisMapper;
        this.paisRepo = paisRepo;
    }

    @Override
    public PaisDTO grabarPais(PaisDTO pais) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PaisDTO> findAll() {
        return paisMapper.entityListToDtoList(
                WebUtils.toList(paisRepo.findAll()));
    }

}
