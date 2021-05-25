package com.stevens.spring.security.config;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FilePasswordManager {

  private static Logger log = LoggerFactory.getLogger(FilePasswordManager.class);

  private Map<String, String> passwordMap;

  public FilePasswordManager() {
    load();
  }

  public String getCredentials(String uName) {
    return passwordMap.get(uName);
  }

  public void load() {
    try {
      List<String> lineContent = FileUtils.readLines(new File(
          "C:\\Users\\Abhishek\\Workspaces\\Spring_All_In_One\\spring\\spring-security-custom\\src\\main\\resources\\passwords.txt"));
      passwordMap = new HashMap<>();
      for (String content : lineContent) {
        String[] c = content.split(" ");
        passwordMap.put(c[0], c[1]);
      }
      System.out.println("Password Manager Loaded with total count of credentials : " + passwordMap.size());
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Passwords File loading error", e.getMessage());
    }


  }
}
