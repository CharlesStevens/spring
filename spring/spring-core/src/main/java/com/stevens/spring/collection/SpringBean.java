package com.stevens.spring.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

	private String message;

	@Autowired
	List<CommonInterface> impls;

//	@Autowired
//	@Qualifier("commonImplementor2")
//	CommonInterface interfaces;

	@Autowired
	List<String> empls;

	@Autowired
	Map<String, String> mapCollect;

	public String getMessage() {
		impls.forEach(t -> t.doSomething());
//		interfaces.doSomething();
		empls.forEach(t -> System.out.println(t));

		mapCollect.forEach((k, v) -> System.out.println(k + " : " + v));
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

	@Bean({ "mapCollect", "mapperCollect" })
	public Map<String, String> hashMapCollection() {
		return new HashMap<String, String>() {
			{

				put("john", "smith");
				put("steve", "baton");
			}
		};
	}
}
