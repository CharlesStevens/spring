package com.stevens.spring.annotations.dependson;

public class SpringBeanA {
	public void init() {
		System.out.println("SpringBeanA init Called");
	}

	public void destory() {
		System.out.println("SpringBeanA destroy Called");
	}

}
