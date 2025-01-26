package com.smga.smga.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("orders", r -> r.path("/api/orders/**")
                        .uri("http://localhost:8080"))
                .route("dinosaurios", r -> r.path("/api/dinosaur-data/**")
                        .uri("http://localhost:8080"))
                .route("marte", r -> r.path("/api/marte/**")
                        .uri("http://localhost:8080"))
                .route("hechizos", r -> r.path("/api/spells/**")
                        .uri("http://localhost:8080"))
                .build();
    }
}

