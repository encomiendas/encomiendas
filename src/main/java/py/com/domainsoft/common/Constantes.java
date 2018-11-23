package py.com.domainsoft.common;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Constantes {

    /**Paginacion*/
    public static final int BUTTONS_TO_SHOW = 5;
    public static final int INITIAL_PAGE = 0;
    public static final int INITIAL_PAGE_SIZE = 5;
    public static final int PEOPLE_INITIAL_PAGE_SIZE = 10;
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
    public static final String MSG_EXITOSO_URL = "seguridad/msg-exitoso";
    
    /**Devuelve el password temporal encriptado con bcrypt*/
    public static final String getTemporalPass() {
        String password = "temporal";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
    
    /**Permite obtener partes de la fecha actual como por ejemplo*/
    /**Integer year = ConstantesBase.traerFechaSistema().get(Calendar.YEAR);
	   Integer month = ConstantesBase.traerFechaSistema().get(Calendar.MONTH)
      */
	public static Calendar traerFechaSistema() {
		long millis = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(millis);
		return now;
	}


	/**le saca lo decimales a un double convertido a string,*/ 
	/**dejandolo como un integer*/
	public static String doubleToIntString(String value) {
		Integer valorInt = new Integer(0);
		String valorStr = "";
		if (value != "") {
			valorInt = (int) Double.parseDouble(value);
			valorStr = valorInt.toString();
		}
		return valorStr;
	}
	
	/** Retorna la fechahora actual */
	public static Timestamp traerFechaHora(){
		return new Timestamp(System.currentTimeMillis());
	}
	
    

}
