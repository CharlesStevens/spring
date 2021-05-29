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

    static int counter = 1;

    @Value("${eureka.instance.hostname}")
    private String eurekaHostname;

    @GetMapping(value = "/returnGetResponse/{count}")
    public ResponseEntity<String> returnGetResponse(HttpServletRequest request, @PathVariable("count") String count) {
        String requestURL = request.getRequestURL().toString();

//        System.out.println("SampleController || Request URL : " + requestURL + " total count : " + counter);
        System.out.println("SampleController || Request URL : " + requestURL + " counter passed by the caller " + count);
        counter++;

        sleep();

        if (false) { // True for testing ribbon retry
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        } else {
            return new ResponseEntity("Return called success", HttpStatus.OK);
        }
    }

    private void sleep() {
        long sleepTime = 0;
        Random r = new Random();

        int high = 0;
        int low = 0;

        if (eurekaHostname.equals("callee1")) {
            low = 8000;
            high = 10000;
        } else if (eurekaHostname.equals("callee2")) {
            low = 5000;
            high = 7500;
        } else if (eurekaHostname.equals("callee3")) {
            low = 2000;
            high = 4000;
        }

        sleepTime = Integer.toUnsignedLong(r.nextInt(high - low) + low);
        try {
            System.out.println("Sleeping for : "+ sleepTime + " milliseconds");
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
