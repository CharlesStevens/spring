package com.swastik.webmvc.interceptor.controllers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomController {

  @Autowired

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public @ResponseBody
  String getEmployee() {
    System.out.println("getEmployee Method Called " + DateTime.now().toString());
    return "Home Called " + DateTime.now().toString();
  }

  @RequestMapping(value = "/work", method = RequestMethod.GET)
  public @ResponseBody
  String getAddress() {
    System.out.println("getAddress Method Called");
    return "work Called";
  }
}
