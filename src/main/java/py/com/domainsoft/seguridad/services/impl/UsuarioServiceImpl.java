package py.com.domainsoft.seguridad.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.domainsoft.common.Constantes;
import py.com.domainsoft.common.WebUtils;
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

    private final UsuarioRepository usuarioRepo;

    private final UsuarioMapper usuarioMapper;

    private final UsuarioRoleRepository usuarioRoleRepo;

    private final RoleRepository roleRepo;
    
    private final EntityManager entityManager;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepo,
            UsuarioMapper usuarioMapper, UsuarioRoleRepository usuarioRoleRepo,
            RoleRepository roleRepo,
            EntityManager entityManager) {
        this.usuarioRepo = usuarioRepo;
        this.usuarioMapper = usuarioMapper;
        this.usuarioRoleRepo = usuarioRoleRepo;
        this.roleRepo = roleRepo;
        this.entityManager = entityManager;
    }
    
    @Override
    @Transactional
    public void actualizarUsuario(UsuarioDTO usuario) {
        
        String sql = "UPDATE usuario ";
        sql += " set login=:login, ";
        sql += " activo=:activo, ";
        sql += " id_persona=:idpersona, ";
        sql += " id_sucursal=:idsucursal ";
        sql += " WHERE id=:id ";
        
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("login", usuario.getLogin());
        query.setParameter("activo", usuario.getActivo());
        query.setParameter("idpersona", usuario.getPersona().getIdPersona());
        query.setParameter("idsucursal", usuario.getSucursal().getIdSucursal());
        query.setParameter("id", usuario.getIdUsuario());
        query.executeUpdate();
        
    }

    @Override
    public void grabarUsuario(UsuarioDTO usuario) {
        
        
        System.out.println("persona : " + usuario.toString());
 
        usuario.setPassword(Constantes.getTemporalPass());
        usuario.setExpira(false);
        
        UsuarioEntity u = usuarioRepo.save(usuarioMapper.dtoToEntity(usuario));

        RoleEntity roleUser = roleRepo.getOne(1); //admin
        RoleEntity roleAdmin = roleRepo.getOne(2); //user

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
        } else {
            return null;
        }

    }

    @Override
    public Page<UsuarioDTO> findAllPageable(Pageable pageable) {
        Page<UsuarioEntity> pageResponse = usuarioRepo.findAll(pageable);
        return pageResponse.map(usuarioMapper::entityToDto);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioMapper
                .entityListToDtoList(WebUtils.toList(usuarioRepo.findAll()));
    }

}
