package com.stevens.annotations.dependson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

	@Bean
//	(initMethod = "init", destroyMethod = "destroy")
	public SpringBeanD getD() {
		System.out.println("SpringD Bean creation Called");
		return new SpringBeanD();
	}

	@Bean
	public SpringBeanA getA() {
		System.out.println("SpringA Bean creation Called");
		return new SpringBeanA();
	}

	@Bean
	public SpringBeanB getB() {
		System.out.println("SpringB Bean creation Called");
		return new SpringBeanB();
	}

	@Bean
	public SpringBeanC getC() {
		System.out.println("SpringC Bean creation Called");
		return new SpringBeanC();
	}

}
