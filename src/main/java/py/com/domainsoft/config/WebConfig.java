package py.com.domainsoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/**");
        resolver.setSuffix(".html");
        return resolver;
    }

}