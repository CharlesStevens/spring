package com.swastik.spring_mvc_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

  @RequestMapping(value = "/hello2", method = RequestMethod.GET)
  public String printHello(ModelMap model) {
    model.addAttribute("message", "Hello2 Spring MVC Framework!");
    return "hello";
  }

}
