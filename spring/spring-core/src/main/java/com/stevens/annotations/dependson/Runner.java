package com.stevens.annotations.dependson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.stevens.annotations.dependson");
		((AnnotationConfigApplicationContext) context).refresh();

		SpringBeanD bean1 = (SpringBeanD) context.getBean(SpringBeanD.class);
		bean1.init();
		bean1.destroy();

		((AnnotationConfigApplicationContext) context).registerShutdownHook();
		((AnnotationConfigApplicationContext) context).close();
	}
}
