package com.swastik.spring_mvc_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/submit")
	public String enterCredentials(@RequestParam("name") String name, @RequestParam("pass") String pass, Model model) {

		if (pass.equals("admin") && name.equals("admin")) {
			model.addAttribute("message", "hello Admin");
			return "viewpage";
		} else {
			model.addAttribute("message", "Wrong credentials, please enter again.");
			return "errorpage";
		}

	}
}
