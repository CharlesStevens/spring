package com.stevens.spring.security_jwt.config;

import java.io.File;
import java.util.*;

import com.stevens.spring.security_jwt.util.Credentials;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FilePasswordManager {

    private static Logger log = LoggerFactory.getLogger(FilePasswordManager.class);

    private Map<String, Credentials> credentials;

    public FilePasswordManager() {
        load();
    }

    public Credentials getCredentials(String uName) {
        return credentials.get(uName);
    }

    public void load() {
        try {
            List<String> lineContent = FileUtils.readLines(new File(
                    "C:\\Users\\Abhishek\\Workspaces\\SpringWorkspace\\spring\\spring\\spring-security-custom\\src\\main\\resources\\passwords.txt"));
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
}
