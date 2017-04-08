package lol.no.hand.service.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.swagger.models.HttpMethod;

@Configuration
public class GlobalConfiguration {
    private static final String ALLOWED_MAPPING = "/**";
    private static final String ALLOWED_ORIGINS = "*";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                .addMapping(ALLOWED_MAPPING)
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedMethods(HttpMethod.GET.toString());
            }
        };
    }
}
