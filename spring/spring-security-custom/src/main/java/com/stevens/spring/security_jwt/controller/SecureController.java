package com.stevens.spring.security_jwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecureController {

    private static Logger log = LoggerFactory.getLogger(SecureController.class);

    @GetMapping(value = "/admin/execute")
    @RolesAllowed("ROLE_ADMIN")
    public String executeRequest() {
        System.out.println("Secure Controller Called");
        return "Execute Method executed successfully";
    }


    @GetMapping(value = "/user/process")
    @RolesAllowed("ROLE_USER")
    public String processRequest() {
        System.out.println("Secure Controller Called");
        return "Process Method executed successfully";
    }


}
