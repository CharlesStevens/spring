package com.stevens.spring.collection;

import org.springframework.stereotype.Component;

@Component
public class CommonImplementor1 implements CommonInterface {

	@Override
	public void doSomething() {
		System.out.println("CommonImplementor1");

	}

}
