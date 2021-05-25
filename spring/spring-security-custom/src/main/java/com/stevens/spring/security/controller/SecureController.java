package com.stevens.spring.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

  private static Logger log = LoggerFactory.getLogger(SecureController.class);

  @GetMapping(value = "/execute")
  public String executeRequest() {
    System.out.println("Secure Controller Called");
    return "Method executed succesfully";
  }
}
