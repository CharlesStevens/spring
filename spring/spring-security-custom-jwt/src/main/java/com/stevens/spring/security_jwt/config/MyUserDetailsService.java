package com.stevens.spring.security_jwt.config;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import com.stevens.spring.security_jwt.util.Credentials;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private static Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    private Map<String, Credentials> credentials;

    public MyUserDetailsService() {
        load();
    }

    public void load() {
        try {
            List<String> lineContent = FileUtils.readLines(new File(
                    "C:\\Users\\Abhishek\\Workspaces\\SpringWorkspace\\spring\\spring\\spring-security-custom-jwt\\src\\main\\resources\\passwords.txt"));
            credentials = new HashMap<>();

            for (String content : lineContent) {
                String[] credentialContent = content.split(" ");
                String username = credentialContent[0];
                String password = credentialContent[1];
                String[] rolesList = credentialContent[2].split(",");
                credentials.put(username, new Credentials(username, password, Arrays.asList(rolesList)));
            }
            System.out.println("Password Manager Loaded with total count of credentials : " + credentials.size());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Passwords File loading error", e.getMessage());
        }


    }

    @Override
    public UserDetails loadUserByUsername(String uName) throws UsernameNotFoundException {
        Credentials cred = credentials.get(uName);
        if (cred == null) throw new UsernameNotFoundException("Username " + uName + " not found ");
        return new User(cred.getUsername(), cred.getPassword(), cred.getRoles().stream().map(t ->
//                new SimpleGrantedAuthority(t.replace("ROLE_", ""))).collect(Collectors.toList()));
        new SimpleGrantedAuthority(t)).collect(Collectors.toList()));
    }
}
