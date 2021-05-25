package com.stevens.springboot.eureka.client.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.stevens.springboot.eureka.client")
public class EurekaClientServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientServer.class, args);
    }


}
