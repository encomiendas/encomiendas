package py.com.domainsoft.seguridad.services.impl;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dtos.PerfilUsuarioDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.mapper.PerfilUsuarioMapper;
import py.com.domainsoft.seguridad.repositories.PerfilUsuarioRepository;
import py.com.domainsoft.seguridad.services.PerfilUsuarioService;

@Service
public class PerfilUsuartioSeviceImpl implements PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepo;
    
    private final PerfilUsuarioMapper perfilUsuarioMapper;
    
    public PerfilUsuartioSeviceImpl(
            PerfilUsuarioRepository perfilUsuarioRepo,
            PerfilUsuarioMapper perfilUsuarioMapper) {
       this.perfilUsuarioRepo = perfilUsuarioRepo;
       this.perfilUsuarioMapper = perfilUsuarioMapper;
    }
    
    @Override
    public List<PerfilUsuarioDTO> perfilesByUsuario(Principal principal) {
        UserDetailsDTO loginedUser = (UserDetailsDTO) ((Authentication) principal).getPrincipal();
        return perfilUsuarioMapper.entityListToDtoList(
                perfilUsuarioRepo.findByUsuarioId(loginedUser.getIdUsuario()));
    }

    
    
}
