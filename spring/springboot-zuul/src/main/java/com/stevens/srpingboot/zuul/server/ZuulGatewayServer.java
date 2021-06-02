package com.stevens.srpingboot.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayServer {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayServer.class, args);
    }
}
