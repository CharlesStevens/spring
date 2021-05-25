package com.stevens.spring_mvc_exception_handling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.swastik.spring_mvc_exception_handling")
public class WebApplicationConfigurer implements WebMvcConfigurer {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);

		view.setPrefix("/WEB-INF/views/");
		view.setSuffix(".jsp");
		return view;
	}

//	@Bean
//	public GlobalExceptionResolver getExceptionResolver() {
//		return new GlobalExceptionResolver();
//	}

	// @Bean
	// public SimpleMappingExceptionResolver getExceptionResolver() {
	// SimpleMappingExceptionResolver execResolver = new
	// SimpleMappingExceptionResolver();
	// Properties prop = new Properties();
	//
	// prop.setProperty("SQLException", "database_error");
	// prop.setProperty("IOException", "404");
	// prop.setProperty("EmployeeNotFoundException", "error");
	// prop.setProperty("Exception", "generic_error");
	// execResolver.setExceptionMappings(prop);
	//
	// return execResolver;
	// }

}
