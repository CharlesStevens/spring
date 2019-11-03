package com.stevens.spring.scopes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SpringBean implements InitializingBean, DisposableBean {

	private String message;

	private SpringBeanA beanA;

	@Autowired(required = false)
	public void setSpringBeanA(SpringBeanA beanA) {
		System.out.println("Initializing SpringBean");
		this.beanA = beanA;
	}

	@PostConstruct
	public void init() {
		System.out.println("## Post Construct Method called");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("## PreDestroy method Called");
	}

	public void destroy() throws Exception {
		System.out.println("## Initializing Bean Destory of DisposableBean Called");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("## After Properties set of InitializingBean");

	}

}
