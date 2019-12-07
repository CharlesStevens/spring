package com.stevens.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.stevens.spring.collection");
		((AnnotationConfigApplicationContext) context).refresh();

		SpringBean bean1 = (SpringBean) context.getBean("springBean");
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
