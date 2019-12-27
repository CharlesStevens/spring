package com.stevens.spring.annotations.dependson;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringBeanD {

	@Autowired
	SpringBeanB b;

	@Autowired
	SpringBeanC c;

	@Autowired
	SpringBeanA a;

	public void destroy() throws Exception {
		System.out.println("SpringBeanD  destory called");

		b.destory();
		c.destory();
		a.destory();

	}

	public void init() throws Exception {
		System.out.println("SpringBeanD init called");

		b.init();
		c.init();
		a.init();
	}

}
