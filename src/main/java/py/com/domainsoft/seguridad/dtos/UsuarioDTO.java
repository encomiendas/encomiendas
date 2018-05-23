package py.com.domainsoft.seguridad.dtos;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

public class UsuarioDTO {

    private Integer idUsuario;

    @NotNull
    private String login;

    @NotNull
    private String password;

    private String correo;

    private boolean activo;

    public UsuarioDTO() {}

    private UsuarioDTO(Integer idUsuario, String login, String password, String correo, boolean activo) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.password = password;
        this.correo = correo;
        this.activo = activo;
    }

    public static class Builder {
        private Integer idUsuario;
        private String login;
        private String password;
        private String correo;
        private boolean activo;

        public Builder idUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public Builder activo(boolean activo) {
            this.activo = activo;
            return this;
        }

        public UsuarioDTO build() {
            return new UsuarioDTO(idUsuario, login, password, correo, activo);
        }
    }
    
    public static Builder builder(){
        return new Builder();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idUsuario", idUsuario)
                .add("login", login)
                .add("password", password)
                .add("correo", correo)
                .add("activo", activo)
                .toString();
    }
    
}
