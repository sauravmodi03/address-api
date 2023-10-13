package com.codecrafted.address.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class ResourceConfig {

    private final CorsConfig config;

    @Bean
    public SecurityFilterChain resourceFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.oauth2ResourceServer( r-> {
            r.jwt( j -> {
                j.jwkSetUri("http://localhost:9000/oauth2/jwks");
            });
        }).authorizeHttpRequests (h -> {
                    h.requestMatchers("/api/address/**").permitAll();
                    h.requestMatchers("/user/register").permitAll();
                    h.anyRequest().permitAll();
                }
        );

        config.corsConfigurationSource(http);
        return http.build();
    }

}
