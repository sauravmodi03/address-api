package com.codecrafted.address.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Component
public class CorsConfig {

    public void corsConfigurationSource(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors( c -> {
            CorsConfigurationSource source = s -> {
                CorsConfiguration config = new CorsConfiguration();
                config.addAllowedHeader("*");
                config.addAllowedMethod("*");
                config.addAllowedOrigin("https://address-finder.codecrafted.in");
                config.addAllowedOrigin("http://localhost:4200");
                config.setAllowCredentials(true);
                return config;
            };
            c.configurationSource(source);
        });
    }
}
