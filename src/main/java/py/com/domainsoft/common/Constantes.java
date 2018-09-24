package py.com.domainsoft.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Constantes {

    /**Paginacion*/
    public static final int BUTTONS_TO_SHOW = 5;
    public static final int INITIAL_PAGE = 0;
    public static final int INITIAL_PAGE_SIZE = 5;
    public static final int[] PAGE_SIZES = { 5, 10, 20 };
    
    /**Aside - head - footers*/
    public static final String MENU_LIST = "menuItemsList";
    public static final String PERFILES_X_USUARIO = "perfiles";
    public static final String PERFIL_OBJECT = "perfil";
    
    /**Session values*/
    public static final String SESSION_MENU = "menu";
    public static final String SESSION_LOGIN_DATA = "logindata";
    
    
    /**Vistas (nombres)*/
    public static final String HOME_VIEW = "home";
    public static final String PERFIL_SELECCION_VIEW = "seguridad/perfil-seleccion";
    public static final String USUARIO_EXITOSO_VIEW = "seguridad/usuario-exitoso";
    public static final String PERFIL_USUARIO_LISTA_VIEW = "seguridad/perfil-usuario-lista";
    
    /**URL*/
    public static final String USUARIO_EXITOSO_URL = "/usuario-exitoso";
    
    /**Devuelve el password temporal encriptado con bcrypt*/
    public static final String getTemporalPass() {
        String password = "temporal";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

}
