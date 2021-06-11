package com.stevens.spring.security_jwt.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomWebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        try {
            AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
            ctx.register(CustomSecurityConfigurerAdapter.class);
            ctx.setServletContext(servletContext);


            ServletRegistration.Dynamic servlet = servletContext
                    .addServlet("dispatcher", new DispatcherServlet(ctx));
            servlet.setLoadOnStartup(1);
            servlet.addMapping("/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


