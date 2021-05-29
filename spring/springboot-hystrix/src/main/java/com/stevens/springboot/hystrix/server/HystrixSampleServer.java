package com.stevens.springboot.hystrix.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.stevens.springboot.hystrix")
@EnableHystrix
public class HystrixSampleServer {
    public static void main(String[] args) {
        SpringApplication.run(HystrixSampleServer.class, args);
    }
}
