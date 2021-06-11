package com.stevens.spring.security_jwt.config;

import com.stevens.spring.security_jwt.util.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    FilePasswordManager passwordManager;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String uName = authentication.getName();
        System.out.println("Authenticating User : " + uName);

        Credentials credentialsObject = passwordManager.getCredentials(uName);

        if (credentialsObject != null & credentialsObject.getPassword().equals(authentication.getCredentials().toString())) {
            System.out.println("User authenticated : " + uName);
            List<GrantedAuthority> authorities = new ArrayList<>();

            if (credentialsObject.getRoles() != null && credentialsObject.getRoles().size() > 0)
                credentialsObject.getRoles().forEach(t -> authorities.add(new SimpleGrantedAuthority(t)));

            return new UsernamePasswordAuthenticationToken(uName,
                    authentication.getCredentials().toString(), authorities);
        }
        System.out.println("Authentication failed for User : " + uName);
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
