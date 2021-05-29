package com.stevens.springboot.hystrix.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("caller")
public class CallerServiceFallback implements CallerService {

    @Override
    public String makeCallToServer(String requestBody) {
        return  "Returned from fallback";
    }
}
