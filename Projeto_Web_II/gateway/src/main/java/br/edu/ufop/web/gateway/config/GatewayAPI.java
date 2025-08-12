package br.edu.ufop.web.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayAPI {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){

        return builder.routes()
        .route("api-users", p -> p.path("/api/users").filters(f -> f.rewritePath("/api/users", "/users")).uri("lb://users-service"))
        .route("users", p -> p.path("/users").uri("lb://users-service"))
        .route("sales", p -> p.path("/sales/**").uri("lb://sales-service"))
        .route("events", p -> p.path("/events/**").uri("lb://sales-service"))
        .route("notifications", p -> p.path("/notifications/**").uri("lb://notifications-service")).build();
    }
}
