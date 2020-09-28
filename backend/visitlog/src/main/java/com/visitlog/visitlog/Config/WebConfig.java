package com.visitlog.visitlog.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Add you arigins here ,to bypass all the origins you can put "*".
                .allowedMethods("PUT", "DELETE","POST","GET") // add allowed methods here
                .allowedHeaders("Origin", "Referer")// add allowed headers here
                .exposedHeaders("Origin", "Referer") // add exposed headers here
                .allowCredentials(false).maxAge(3600);
    }
}
