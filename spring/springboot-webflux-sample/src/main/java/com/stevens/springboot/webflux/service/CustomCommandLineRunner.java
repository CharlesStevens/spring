package com.stevens.springboot.webflux.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {
    private WebClient client = WebClient.create("http://localhost:8080");
    // For getting all users
    private Mono<ClientResponse> result = client.post()
            .uri("/getEmployee")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();


    @Override
    public void run(String... args) throws Exception {
        Thread.sleep(2000);
        System.out.println("Calling getEmployee");
        Flux<String> userList = result.flatMapMany(res -> res.bodyToFlux(String.class));
        System.out.println("GetEmployee Response : " + userList.collectList().block());
    }
}