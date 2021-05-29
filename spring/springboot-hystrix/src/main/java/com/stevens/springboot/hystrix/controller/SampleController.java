package com.stevens.springboot.hystrix.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@Profile("callee")
public class SampleController {

    @Value("${eureka.instance.hostname}")
    private String eurekaHostname;

    @GetMapping(value = "/returnGetResponse")
    public ResponseEntity<String> returnGetResponse(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        System.out.println("SampleController || Request URL : " + requestURL);


        Random r = new Random();
        int random = r.nextInt(10 - 1) + 1;

        if (random > 8) {
            System.out.println("Sending Failure");
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        } else {
            System.out.println("Sending Success");
            return new ResponseEntity("Success Returned from the caller", HttpStatus.OK);
        }
    }


}
