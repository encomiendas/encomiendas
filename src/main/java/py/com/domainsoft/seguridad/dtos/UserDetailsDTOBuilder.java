package py.com.domainsoft.seguridad.dtos;

import org.springframework.security.core.GrantedAuthority;

import py.com.domainsoft.entidad.dtos.SucursalDTO;

import java.time.LocalDate;
import java.util.List;

public class UserDetailsDTOBuilder {
    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> grantedAuthorities;
    private boolean expira;
    private LocalDate fechaExpiracion;
    private PersonaDTO persona;
    private SucursalDTO sucursal;
    
    public UserDetailsDTOBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserDetailsDTOBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserDetailsDTOBuilder enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public UserDetailsDTOBuilder grantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
        return this;
    }
    
    public UserDetailsDTOBuilder expira(boolean expira){
        this.expira = expira;
        return this;
    }
    
    public UserDetailsDTOBuilder fechaExpiracion(LocalDate fechaExpiracion){
        this.fechaExpiracion = fechaExpiracion;
        return this;
    }
    
    public UserDetailsDTOBuilder persona(PersonaDTO persona){
        this.persona = persona;
        return this;
    }
    
    public UserDetailsDTOBuilder sucursal(SucursalDTO sucursal){
        this.sucursal = sucursal;
        return this;
    }
    
    public UserDetailsDTO build() {
        return new UserDetailsDTO(username,
                password,
                enabled,
                grantedAuthorities,
                expira,
                fechaExpiracion,
                persona,
                sucursal);
    }
}