package py.com.domainsoft.seguridad.services.impl;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dtos.PerfilUsuarioDTO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.entities.PerfilEntity;
import py.com.domainsoft.seguridad.entities.PerfilUsuarioEntity;
import py.com.domainsoft.seguridad.entities.UsuarioEntity;
import py.com.domainsoft.seguridad.mapper.PerfilUsuarioMapper;
import py.com.domainsoft.seguridad.repositories.PerfilRepository;
import py.com.domainsoft.seguridad.repositories.PerfilUsuarioRepository;
import py.com.domainsoft.seguridad.repositories.UsuarioRepository;
import py.com.domainsoft.seguridad.services.PerfilUsuarioService;

@Service
public class PerfilUsuartioSeviceImpl implements PerfilUsuarioService {

    private final PerfilUsuarioRepository perfilUsuarioRepo;
    
    private final PerfilUsuarioMapper perfilUsuarioMapper;
    
    private final UsuarioRepository usuarioRepo;
    
    private final PerfilRepository perfilRepository;
    
    public PerfilUsuartioSeviceImpl(
            PerfilUsuarioRepository perfilUsuarioRepo,
            PerfilUsuarioMapper perfilUsuarioMapper,
            UsuarioRepository usuarioRepo,
            PerfilRepository perfilRepository) {
       this.perfilUsuarioRepo = perfilUsuarioRepo;
       this.perfilUsuarioMapper = perfilUsuarioMapper;
       this.usuarioRepo = usuarioRepo;
       this.perfilRepository = perfilRepository;
    }
    
    @Override
    public List<PerfilUsuarioDTO> perfilesByUsuario(Principal principal) {
        UserDetailsDTO loginedUser = (UserDetailsDTO) ((Authentication) principal).getPrincipal();
        return perfilUsuarioMapper.entityListToDtoList(
                perfilUsuarioRepo.findByUsuarioId(loginedUser.getIdUsuario()));
    }

    @Override
    public List<PerfilUsuarioDTO> perfilesByUsuario(Integer idusuario) {
        return perfilUsuarioMapper.entityListToDtoList(
                perfilUsuarioRepo.findByUsuarioId(idusuario));
    }

    @Override
    public void grabarPerfilesPorUsuario(Integer idUsuario,
            Integer[] perfiles) {
        
        List<PerfilUsuarioEntity> perfilesUsuario = 
                perfilUsuarioRepo.findByUsuarioId(idUsuario);
        
        perfilUsuarioRepo.deleteAll(perfilesUsuario);
        perfilUsuarioRepo.flush();
        
        UsuarioEntity usuarioEntity = usuarioRepo.
                findById(idUsuario).get();
        
        for (int i = 0; i < perfiles.length; i++) {            
            PerfilEntity perfilEntity = 
                    perfilRepository.findById(perfiles[i]).get();
            PerfilUsuarioEntity p = new PerfilUsuarioEntity();
            p.setPerfil(perfilEntity);
            p.setUsuario(usuarioEntity);
            perfilUsuarioRepo.save(p);
        }
    }

    
    
}
