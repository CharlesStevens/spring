package com.stevens.springboot.webflux.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.stevens.springboot.webflux")
public class SpringWebfluxServer {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxServer.class, args);
    }
}
