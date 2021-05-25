package com.stevens.spring_mvc_1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stevens.spring_mvc_1.model.Employee;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public Employee printHello() {
		return new Employee(3423, "John", 3283290L);
	}

}
