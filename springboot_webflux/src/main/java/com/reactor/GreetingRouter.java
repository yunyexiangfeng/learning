package com.reactor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class GreetingRouter {


    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler handler){
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
    }
}
