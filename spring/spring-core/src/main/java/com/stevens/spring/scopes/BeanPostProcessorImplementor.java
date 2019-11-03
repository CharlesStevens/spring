package com.stevens.spring.scopes;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorImplementor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("## BeanPostProcessor Before one called - Bean Name : " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("## BeanPostProcessor After one called - Bean Name : " + beanName);
		return bean;
	}

}
