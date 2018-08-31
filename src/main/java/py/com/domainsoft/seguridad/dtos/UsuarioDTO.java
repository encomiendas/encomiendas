package py.com.domainsoft.seguridad.dtos;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.dtos.SucursalDTO;

public class UsuarioDTO {

    private Integer idUsuario;

    @NotNull
    private String login;

    @NotNull
    private String password;

    private boolean activo;
    
    private PersonaDTO persona;
    
    private SucursalDTO sucursal;

    public UsuarioDTO() {}

    private UsuarioDTO(Integer idUsuario, 
            String login,
            String password,
            boolean activo,
            PersonaDTO persona,
            SucursalDTO sucursal) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.password = password;
        this.activo = activo;
        this.persona = persona;
        this.sucursal = sucursal;
    }

    public static class Builder {
        private Integer idUsuario;
        private String login;
        private String password;
        private boolean activo;
        private PersonaDTO persona;
        private SucursalDTO sucursal;

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

        public Builder activo(boolean activo) {
            this.activo = activo;
            return this;
        }
        
        public Builder persona(PersonaDTO persona) {
            this.persona = persona;
            return this;
        }
        
        public Builder sucursal(SucursalDTO sucursal) {
            this.sucursal = sucursal;
            return this;
        }

        public UsuarioDTO build() {
            return new UsuarioDTO(idUsuario, login, password, activo, persona, sucursal);
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public PersonaDTO getPersona() {
        return persona;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idUsuario", idUsuario)
                .add("login", login)
                .add("password", password)
                .add("activo", activo)
                .add("persona", persona)
                .add("sucursal", sucursal)
                .toString();
    }
    
}
