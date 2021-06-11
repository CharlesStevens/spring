package com.stevens.spring.security_jwt.config;

import com.stevens.spring.security_jwt.util.JWTFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan(basePackages = "com.stevens.spring.security_jwt")
@EnableGlobalMethodSecurity(
        securedEnabled = true, // enables @Secured
        jsr250Enabled = true,  // enables @RolesAllowed
        prePostEnabled = true  // enables @PreAuthorize, @PostAuthorize , @PreFilter @PostFiler
)
public class CustomSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private static Logger log = LoggerFactory.getLogger("CustomSecurityConfigurerAdapter");

    @Autowired
    private RestBasicAuthenticationEntryPoint entryPoint;

    @Autowired
    private MyUserDetailsService userServiceManager;

    @Autowired
    private JWTFilter filter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userServiceManager);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/authentication").permitAll().anyRequest().
                authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        System.out.println("Http Security configured");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
	public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
