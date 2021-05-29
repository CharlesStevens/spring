package com.stevens.springboot.webflux.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;


@Component
public class RouterHandlers {

    public Mono<ServerResponse> handleRequest(ServerRequest serverRequest) {
        try {
            System.out.println("Router Handler invoked ");
            Mono<String> body = serverRequest.bodyToMono(String.class);
            System.out.println("Body Received : " + body.toString());

            ServerRequest.Headers headers = serverRequest.headers();

            HttpHeaders httpHeaders = headers.asHttpHeaders();
            for (Map.Entry<String, List<String>> e : httpHeaders.entrySet()) {
                System.out.println("Headers  : " + e.getKey() + " | Value : " + e.getValue().toString());
            }

            MultiValueMap<String, String> queryparams = serverRequest.queryParams();
            for (Map.Entry<String, List<String>> e : queryparams.entrySet()) {
                System.out.println("QueryParams  : " + e.getKey() + " | Value : " + e.getValue().toString());
            }


            Mono<ServerResponse> notFound = ServerResponse.notFound().build();
            Mono<String> userMono = Mono.justOrEmpty("{\"response\":\"Response_@_Value\"");
            return userMono.flatMap(user -> ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(BodyInserters.fromObject(user)))
                    .switchIfEmpty(notFound);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
