package com.stevens.springboot.hystrix.service;

import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class CustomExceptionHandler {


    @ExceptionHandler(FeignException.class)
    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
        e.printStackTrace();
        response.setStatus(e.status());
        return "feignError";
    }

    @ExceptionHandler(Exception.class)
    public String handleFeignStatusEx(Exception e) {
        e.printStackTrace();
//        response.setStatus(e.status());
        return "feignError";
    }


}