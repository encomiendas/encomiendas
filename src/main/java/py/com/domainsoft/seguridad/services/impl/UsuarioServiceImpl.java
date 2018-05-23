package py.com.domainsoft.seguridad.services.impl;

import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dtos.UsuarioDTO;
import py.com.domainsoft.seguridad.mapper.UsuarioMapper;
import py.com.domainsoft.seguridad.repositories.UsuarioRepository;
import py.com.domainsoft.seguridad.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepository usuarioRepo;

    UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepo,
            UsuarioMapper usuarioMapper) {
        this.usuarioRepo = usuarioRepo;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public void grabarUsuario(UsuarioDTO usuario) {
        usuarioRepo.save(usuarioMapper.dtoToEntity(usuario));
    }

    @Override
    public UsuarioDTO findByLogin(String login) {
        System.out.println("en el service impl es : " + login);
        return usuarioMapper.entityToDto(usuarioRepo.findByLogin(login));
    }

}
