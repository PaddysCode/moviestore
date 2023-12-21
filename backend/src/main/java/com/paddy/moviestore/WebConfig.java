package com.paddy.moviestore;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Erlaubte Ursprünge (Domains)
                .allowedMethods("*") // Erlaubte HTTP-Methoden
                .allowedHeaders("*") // Erlaubte Header
                .allowCredentials(true); // Erlaubt Cookies und Authentifizierung
    }
}
