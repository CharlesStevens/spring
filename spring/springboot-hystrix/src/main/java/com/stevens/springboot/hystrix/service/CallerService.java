package com.stevens.springboot.hystrix.service;

import org.springframework.http.ResponseEntity;

public interface CallerService {

    public ResponseEntity<String> makeCallToServer();

    public ResponseEntity<String> callerFallbackMethod();
}
