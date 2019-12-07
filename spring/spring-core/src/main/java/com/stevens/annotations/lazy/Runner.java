package com.stevens.annotations.lazy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.stevens.annotations.lazy");
		((AnnotationConfigApplicationContext) context).refresh();

		SpringBeanA bean1 = (SpringBeanA) context.getBean("springBeanA");
		bean1.setMessage("Hello Spring");

		System.out.println("Bean invocation first time : " + bean1.getMessage());
//
//		SpringBean bean2 = (SpringBean) context.getBean("springBean");
//
//		System.out.println("Bean invocation Second time : " + bean2.getMessage());
		((AnnotationConfigApplicationContext) context).registerShutdownHook();
		((AnnotationConfigApplicationContext) context).close();
	}
}
