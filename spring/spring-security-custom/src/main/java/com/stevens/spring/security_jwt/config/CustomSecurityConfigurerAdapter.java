package com.stevens.spring.security_jwt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan(basePackages = "com.stevens.spring.security")
@EnableGlobalMethodSecurity(
        securedEnabled = true, // enables @Secured
        jsr250Enabled = true,  // enables @RolesAllowed
        prePostEnabled = true  // enables @PreAuthorize, @PostAuthorize , @PreFilter @PostFiler
)
public class CustomSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private static Logger log = LoggerFactory.getLogger("CustomSecurityConfigurerAdapter");

    @Autowired
    RestBasicAuthenticationEntryPoint entryPoint;

    @Autowired
    AuthenticationProvider authProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        System.out.println("Global Configuration with Authentication Provider Initialized, authProvider Instance : "
                + authProvider.toString());
        builder.authenticationProvider(authProvider);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
//                .antMatchers("/admin/*").hasRole("ADMIN").antMatchers("/user/*").hasRole("USER")
                .anyRequest().authenticated()
                .and().anonymous().disable();
        http.httpBasic()
                .authenticationEntryPoint(entryPoint);

        System.out.println("Http Security configured");
    }
}
