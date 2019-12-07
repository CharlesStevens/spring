package com.stevens.annotations.beans;

public class SpringBeanD {

	public void execute() {
		System.out.println("SpringD init is executed");
	}

	public void destroy() {
		System.out.println("SpringD destroy executed");
	}
}
