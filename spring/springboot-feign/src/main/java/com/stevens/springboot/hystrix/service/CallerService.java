package com.stevens.springboot.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sample-feign-callee", fallback = CallerServiceFallback.class)
@Profile("caller")
public interface CallerService {

    @PostMapping("/returnGetResponse")
    public String makeCallToServer(@RequestBody String requestBody);

}
