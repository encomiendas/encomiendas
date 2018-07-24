package py.com.domainsoft.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Constantes {

    public static final int BUTTONS_TO_SHOW = 5;
    public static final int INITIAL_PAGE = 0;
    public static final int INITIAL_PAGE_SIZE = 5;
    public static final int[] PAGE_SIZES = { 5, 10, 20 };

    public static final String getTemporalPass() {
        String password = "temporal";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

}
