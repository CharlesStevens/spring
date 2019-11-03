package com.stevens.spring.scopes;

import org.springframework.stereotype.Component;

@Component
public class SpringBeanA {

	public SpringBeanA() {
		System.out.println("Spring Bean A initialized");
	}

}
