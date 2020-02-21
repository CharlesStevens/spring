package com.swastik.webmvc.interceptor.config;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.swastik.webmvc.interceptor.controllers.CustomHandlerInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.swastik.webmvc.interceptor")
public class SpringWebConfigurer implements WebMvcConfigurer {

	@Bean
	public ViewResolver getResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public CustomHandlerInterceptor getInterceptor() {
		return new CustomHandlerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getInterceptor()).addPathPatterns("/home");
	}

}
