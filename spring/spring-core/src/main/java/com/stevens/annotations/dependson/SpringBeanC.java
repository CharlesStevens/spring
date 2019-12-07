package com.stevens.annotations.dependson;

import org.springframework.stereotype.Component;

public class SpringBeanC {
	public void init() {
		System.out.println("SpringBeanC init Called");
	}

	public void destory() {
		System.out.println("SpringBeanC destroy Called");
	}
}
