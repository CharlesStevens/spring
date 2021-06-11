package com.stevens.spring.security_jwt.controller;

import com.stevens.spring.security_jwt.util.JWTTokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecureController {

    private static Logger log = LoggerFactory.getLogger(SecureController.class);

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    JWTTokenGenerator tokenGenerator;

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

    @GetMapping(value = "/authentication")
    public String getAuthentication(@RequestParam("user") String username,
                                    @RequestParam("password") String password) {

        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("############## Authentication Failure");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String jwtToken = tokenGenerator.generateToken(userDetails.getUsername());


        return "JWT TOKEN : " + jwtToken;
    }


}
