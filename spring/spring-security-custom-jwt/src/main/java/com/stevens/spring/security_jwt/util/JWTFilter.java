package com.stevens.spring.security_jwt.util;

import com.stevens.spring.security_jwt.config.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    JWTTokenGenerator tokenGenerator;

    @Autowired
    MyUserDetailsService detailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authContent = httpServletRequest.getHeader("Authorization");
        String jwtToken = null;
        String username = null;

        if (authContent != null && !authContent.isEmpty()) {
            jwtToken = authContent.substring(7);
            username = tokenGenerator.extractUsername(jwtToken);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = detailsService.loadUserByUsername(username);

            if (tokenGenerator.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,null,userDetails.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
