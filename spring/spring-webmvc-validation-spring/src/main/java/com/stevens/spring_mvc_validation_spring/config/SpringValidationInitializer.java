package com.stevens.spring_mvc_validation_spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringValidationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		try {
			AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
			appCtx.register(SpringValidationConfigurer.class);
			appCtx.setServletContext(ctx);

			Dynamic d = ctx.addServlet("dispatcher", new DispatcherServlet(appCtx));
			d.addMapping("/");
			d.setLoadOnStartup(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
