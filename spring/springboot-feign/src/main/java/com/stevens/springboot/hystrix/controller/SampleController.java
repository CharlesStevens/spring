package com.stevens.springboot.hystrix.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@Profile("callee")
public class SampleController {

    @Value("${eureka.instance.hostname}")
    private String eurekaHostname;

    @PostMapping(value = "/returnGetResponse")
    public ResponseEntity<String> returnGetResponse(HttpServletRequest request, @RequestBody String requestBody) {
        String requestURL = request.getRequestURL().toString();
        System.out.println("SampleController || Request URL : " + requestURL);
        System.out.println("Request Body received : " + requestBody);

        return new ResponseEntity("Success Returned from the caller", HttpStatus.OK);
    }


}
