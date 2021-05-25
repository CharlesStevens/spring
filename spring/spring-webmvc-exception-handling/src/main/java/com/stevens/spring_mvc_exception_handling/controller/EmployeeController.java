package com.stevens.spring_mvc_exception_handling.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stevens.spring_mvc_exception_handling.exception.EmployeeNotFoundException;
import com.stevens.spring_mvc_exception_handling.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String getEmployee(@PathVariable("id") int empId, Model model) throws Exception {

		if (empId == 1) {
			throw new EmployeeNotFoundException(1);
		} else if (empId == 2) {
			throw new SQLException("SQL Exception occurred for ID : " + empId);
		} else if (empId == 3) {
			throw new IOException("IOException Occurred for ID : " + empId);
		} else if (empId == 10) {
			Employee emp = new Employee();
			emp.setId(122858);
			emp.setName("Abhishek");
			model.addAttribute("employee", emp);
			return "home";
		} else {
			throw new Exception("Generic Exception, Id : " + empId);
		}
	}
//
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
//		System.out.println("Requested URL=" + request.getRequestURL());
//		System.out.println("Exception Raised=" + ex);
//
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("exception", ex);
//		modelAndView.addObject("url", request.getRequestURL());
//
//		modelAndView.setViewName("error");
//		return modelAndView;
//	}
}
