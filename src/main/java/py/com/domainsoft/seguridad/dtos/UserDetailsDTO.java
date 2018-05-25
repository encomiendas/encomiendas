package py.com.domainsoft.seguridad.dtos;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
    private final String correo;

    UserDetailsDTO(String username,
            String password,
            boolean enabled,
            List<GrantedAuthority> grantedAuthorities,
            String correo) {
        this.password = password;
        this.username = username;
        this.enabled = enabled;
        this.grantedAuthorities = grantedAuthorities;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }
    
   
}
