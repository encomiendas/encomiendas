package py.com.domainsoft.seguridad.dtos;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.seguridad.entities.PerfilEntity;
import py.com.domainsoft.seguridad.entities.UsuarioEntity;

public class PerfilUsuarioDTO {

    private Integer idPerfilUsuario;

    private PerfilEntity perfil;

    private UsuarioEntity usuario;

    public Integer getIdPerfilUsuario() {
        return idPerfilUsuario;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setIdPerfilUsuario(Integer idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPerfilUsuario", idPerfilUsuario)
                .add("perfil", perfil)
                .add("usuario", usuario)
                .toString();
    }

}
