package com.stevens.springboot.webflux.configuration;

import com.stevens.springboot.webflux.handlers.RouterHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(RouterHandlers handlers) {
        System.out.println("initialized..............");
//        return RouterFunctions.route().POST("/getEmployee", handlers::handleRequest).build();
        return RouterFunctions.route(RequestPredicates.POST("/getEmployee")
                , handlers::handleRequest);
    }
}
