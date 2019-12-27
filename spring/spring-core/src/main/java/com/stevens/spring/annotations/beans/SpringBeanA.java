package com.stevens.spring.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanA {
	private String message;

	@Autowired
	SpringBeanB beanB;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

@Configuration
class ConfigClass {

	@Bean
	public SpringBeanB getSpringBeanB() {
		return new SpringBeanB();
	}
	
	@Bean()
	@Primary
	public SpringBeanB getSpringBeanB2() {
		return new SpringBeanB();
	}

}
