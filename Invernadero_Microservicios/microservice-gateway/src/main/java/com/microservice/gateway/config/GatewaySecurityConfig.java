package com.microservice.gateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
       http.authorizeExchange()
                .pathMatchers("/api/login", "/api/register").permitAll()  
                .anyExchange().authenticated() 
                .and().oauth2ResourceServer().jwt();  
        return http.build();
    }


}

