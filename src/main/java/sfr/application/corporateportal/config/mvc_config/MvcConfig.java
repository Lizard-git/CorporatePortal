package sfr.application.corporateportal.config.mvc_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/img/news/**")
                .addResourceLocations("file:/" + uploadPath + "/news/");
        registry.addResourceHandler("/files/user/**")
                .addResourceLocations("file:/" + uploadPath + "/users/");
    }
}
