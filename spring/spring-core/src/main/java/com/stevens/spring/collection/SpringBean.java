package com.stevens.spring.collection;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

	private String message;

	// @Autowired
	// List<CommonInterface> impls;

	@Autowired
	@Qualifier("commonImplementor2")
	CommonInterface interfaces;

	@Autowired
	List<String> empls;

	public String getMessage() {
		// impls.forEach(t -> t.doSomething());
		interfaces.doSomething();
		empls.forEach(t -> System.out.print(t));
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

@Configuration
class ConfigCustom {
	@Bean
	public List<String> empls() {
		return Arrays.asList("John", "smith", "warner");
	}
}
