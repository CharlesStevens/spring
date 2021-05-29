package com.stevens.springboot.webflux.handlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/getAddress")
    public String getAddress(){
        return "Invoked Successfully";
    }
}
