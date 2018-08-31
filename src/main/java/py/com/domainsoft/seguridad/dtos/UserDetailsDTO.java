package py.com.domainsoft.seguridad.dtos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import py.com.domainsoft.entidad.dtos.SucursalDTO;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * Created by mcespedes on 11/16/17.
 */
public class UserDetailsDTO implements UserDetails {

    private final String password;
    private final  String username;
    private final boolean enabled;
    private final List<GrantedAuthority> grantedAuthorities;
    private final boolean expira;
    private final LocalDate fechaExpiracion;
    private final PersonaDTO persona;
    private final SucursalDTO sucursal;

    UserDetailsDTO(String username,
            String password,
            boolean enabled,
            List<GrantedAuthority> grantedAuthorities,
            boolean expira,
            LocalDate fechaExpiracion,
            PersonaDTO persona,
            SucursalDTO sucursal) {
        this.password = password;
        this.username = username;
        this.enabled = enabled;
        this.grantedAuthorities = grantedAuthorities;
        this.expira = expira;
        this.fechaExpiracion = fechaExpiracion;
        this.persona = persona;
        this.sucursal = sucursal;
    }

    public static UserDetailsDTOBuilder builder() {
        return new UserDetailsDTOBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    
    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public boolean isExpira() {
        return expira;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
   
}
