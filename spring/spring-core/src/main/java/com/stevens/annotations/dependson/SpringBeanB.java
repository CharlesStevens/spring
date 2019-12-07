package com.stevens.annotations.dependson;

import org.springframework.stereotype.Component;

public class SpringBeanB {

	public void init() {
		System.out.println("SpringBeanB init Called");
	}

	public void destory() {
		System.out.println("SpringBeanB destroy Called");
	}
}
