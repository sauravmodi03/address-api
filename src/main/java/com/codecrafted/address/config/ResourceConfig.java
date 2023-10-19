package com.codecrafted.address.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class ResourceConfig {

    private final CorsConfig config;

    @Bean
    @Order(2)
    public SecurityFilterChain resourceFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.oauth2ResourceServer( r-> {
            r.jwt( j -> {
                j.jwkSetUri("http://localhost:8090/oauth2/jwks");
            });
        });
        http.authorizeHttpRequests (h -> {
                    h.requestMatchers("/health").permitAll();
                    h.requestMatchers("/api/address/test").permitAll();
                    h.requestMatchers("/api/address/get/listaddress/**").permitAll();
                    h.requestMatchers("/api/address/get/**").permitAll();
                    h.requestMatchers("/user/register").permitAll();
                    h.anyRequest().authenticated();
                }
        );

        config.corsConfigurationSource(http);
        return http.build();
    }

}
