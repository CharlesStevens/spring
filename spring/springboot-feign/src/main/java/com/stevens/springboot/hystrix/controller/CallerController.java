package com.stevens.springboot.hystrix.controller;

import com.stevens.springboot.hystrix.service.CallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("caller")
public class CallerController {

    @Autowired
    CallerService callerService;


    @PostMapping("/call")
    public String callServer(@RequestBody String requestBody) {
        System.out.println("Request recieved : " + requestBody);
        return callerService.makeCallToServer(requestBody);
    }


}
