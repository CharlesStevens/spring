package com.stevens.spring_mvc_validation_spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.stevens.spring_mvc_validation_spring.validator.EmployeeFormValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.stevens.spring_mvc_validation_spring")
public class SpringValidationConfigurer implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// viewResolver.setViewClass(JstlView.class);

		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	@Qualifier("employeeValidator")
	public EmployeeFormValidator employeeValidator() {
		return new EmployeeFormValidator();
	}

	@Bean
	public ReloadableResourceBundleMessageSource getResourceBundleMessage() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:messages");
		source.setDefaultEncoding("UTF-8");
		return source;
	}

}
