package com.stevens.annotations.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanA {
	private String message;

	@Autowired
	@Lazy
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
	@Lazy
	public SpringBeanB getSpringBeanB() {
		System.out.println("Called SpringBean B creation method");
		return new SpringBeanB();
	}

}
