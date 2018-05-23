package py.com.domainsoft.seguridad.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import py.com.domainsoft.seguridad.dao.UsuarioDAO;
import py.com.domainsoft.seguridad.dao.UsuarioRoleDAO;
import py.com.domainsoft.seguridad.dtos.UserDetailsDTO;
import py.com.domainsoft.seguridad.entities.UsuarioEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UsuarioDAO appUserDAO;
 
    @Autowired
    private UsuarioRoleDAO appRoleDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UsuarioEntity appUser = this.appUserDAO.findUserAccount(userName);
 
        if (appUser == null) {
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getId());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        
        return UserDetailsDTO.builder()
        .username(appUser.getLogin())
        .password(appUser.getPassword())
        .enabled(appUser.isActivo())
        .grantedAuthorities(this.getGrantedAuthorities(grantList))
        .correo(appUser.getCorreo())
        .build();
        
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(List<GrantedAuthority> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (GrantedAuthority role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }
 
}