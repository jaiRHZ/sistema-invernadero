package com.example.microservice_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewaySecurityConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes().
                route("api/sensor",m -> m.path("/api/sensor/**").uri("http://localhost:8083"))
                .route("api/invernadero", m -> m.path("/api/invernadero/**").uri("http://localgost:8084")).build();
    }

}
