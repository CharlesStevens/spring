package com.swastik.spring.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private static Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

  @Autowired
  FilePasswordManager passwordManager;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String uName = authentication.getName();
    System.out.println("Authenticating User : " + uName);

    String password = passwordManager.getCredentials(uName);

    if (password != null & password.equals(authentication.getCredentials().toString())) {
      System.out.println("User authenticated : " + uName);
      return new UsernamePasswordAuthenticationToken(uName,
          authentication.getCredentials().toString(), null);
    }
    System.out.println("Authentication failed for User : " + uName);
    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
