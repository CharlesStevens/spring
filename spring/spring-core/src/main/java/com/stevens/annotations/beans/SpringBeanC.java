package com.stevens.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanC {
	private String message;

	@Autowired
	SpringBeanD beanD;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

@Configuration
class ConfigurationClass {

//	@Bean(autowireCandidate = false)
	@Bean(initMethod = "execute", destroyMethod = "destroy")
	public SpringBeanD getBean() {
		System.out.println("SpringBeanD bean creation config called");
		return new SpringBeanD();
	}
}
