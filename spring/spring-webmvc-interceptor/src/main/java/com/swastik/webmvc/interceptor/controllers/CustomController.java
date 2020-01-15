package com.swastik.webmvc.interceptor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public @ResponseBody String getEmployee() {
		System.out.println("getEmployee Method Called");
		return "Home Called";

	}
}
