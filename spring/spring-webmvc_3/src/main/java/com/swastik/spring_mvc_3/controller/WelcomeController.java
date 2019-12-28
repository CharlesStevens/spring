package com.swastik.spring_mvc_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
  public String welcome(ModelMap model) {
    model.addAttribute("message", "Welcome Spring MVC Framework!");
    return "welcome";
  }
  
  @RequestMapping(value = "/welcome2", method = RequestMethod.GET)
  public String welcome2(ModelMap model) {
    model.addAttribute("console", "Welcome2 Spring MVC Framework!");
    return "welcome2";
  }

}
