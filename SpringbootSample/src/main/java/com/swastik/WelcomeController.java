package com.swastik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@Value("${welcome.message}")
	private String message;

	@Autowired
	ComponentService service;

	@RequestMapping("/")
	public String welcome() {
		System.out.println("Message From Property File : " + message);
		service.invokeCustomMessage(4, 5);
		return "welcome";
	}
}
