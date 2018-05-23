package py.com.domainsoft.seguridad.dtos;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class UserDetailsDTOBuilder {
    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> grantedAuthorities;
    private String correo;

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
    
    public UserDetailsDTOBuilder correo ( String correo){
        this.correo = correo;
        return this;
    }

    public UserDetailsDTO build() {
        return new UserDetailsDTO(username, password, enabled, grantedAuthorities, correo);
    }
}