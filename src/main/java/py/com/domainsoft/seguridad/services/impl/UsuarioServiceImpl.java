package py.com.domainsoft.seguridad.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.seguridad.dtos.UsuarioDTO;
import py.com.domainsoft.seguridad.entities.RoleEntity;
import py.com.domainsoft.seguridad.entities.UsuarioEntity;
import py.com.domainsoft.seguridad.entities.UsuarioRoleEntity;
import py.com.domainsoft.seguridad.mapper.UsuarioMapper;
import py.com.domainsoft.seguridad.repositories.RoleRepository;
import py.com.domainsoft.seguridad.repositories.UsuarioRepository;
import py.com.domainsoft.seguridad.repositories.UsuarioRoleRepository;
import py.com.domainsoft.seguridad.services.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepository usuarioRepo;

    UsuarioMapper usuarioMapper;
    
    UsuarioRoleRepository usuarioRoleRepo;
    
    RoleRepository roleRepo;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepo,
            UsuarioMapper usuarioMapper,
            UsuarioRoleRepository usuarioRoleRepo,
            RoleRepository roleRepo) {
        this.usuarioRepo = usuarioRepo;
        this.usuarioMapper = usuarioMapper;
        this.usuarioRoleRepo = usuarioRoleRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public void grabarUsuario(UsuarioDTO usuario) {
        usuario.setPassword(Constantes.getTemporalPass());
        usuario.setActivo(true);        
        UsuarioEntity u = usuarioRepo.save(usuarioMapper.dtoToEntity(usuario));
        
        RoleEntity roleUser = roleRepo.getOne(1);
        RoleEntity roleAdmin = roleRepo.getOne(2);
        
        UsuarioRoleEntity uRoleUser = new UsuarioRoleEntity();
        uRoleUser.setRoles(roleUser);
        uRoleUser.setUsuario(u);
        
        usuarioRoleRepo.save(uRoleUser);
        
        UsuarioRoleEntity uRoleAdmin = new UsuarioRoleEntity();
        uRoleAdmin.setRoles(roleAdmin);
        uRoleAdmin.setUsuario(u);
        
        usuarioRoleRepo.save(uRoleAdmin);
        
    }

    @Override
    public UsuarioDTO findByLogin(String login) {
        
        UsuarioEntity usuarioEntity = usuarioRepo.findByLogin(login);
        
        if (usuarioEntity != null) {
            return usuarioMapper.entityToDto(usuarioEntity);
        }else{
            return null;
        }
        
        
    }

    @Override
    public Page<UsuarioDTO> findAllPageable(Pageable pageable) {
        Page<UsuarioEntity> pageResponse = usuarioRepo.findAll(pageable);
        return pageResponse.map(usuarioMapper::entityToDto);
    }

}
