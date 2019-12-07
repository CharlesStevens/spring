package com.stevens.annotations.dependson;

import org.springframework.stereotype.Component;

public class SpringBeanA {
	public void init() {
		System.out.println("SpringBeanA init Called");
	}

	public void destory() {
		System.out.println("SpringBeanA destroy Called");
	}

}
