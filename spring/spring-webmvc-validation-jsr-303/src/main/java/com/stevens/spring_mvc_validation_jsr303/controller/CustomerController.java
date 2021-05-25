package com.stevens.spring_mvc_validation_jsr303.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stevens.spring_mvc_validation_jsr303.model.Customer;

@Controller
public class CustomerController {

	private Map<String, Customer> customers = null;

	public CustomerController() {
		customers = new HashMap<String, Customer>();
	}

	@RequestMapping(value = "/cust/save", method = RequestMethod.GET)
	public String saveCustomerPage(Model model) {
		System.out.println("Returning custSave.jsp page");
		model.addAttribute("customer", new Customer());
		return "custSave";
	}

	@RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
	public String saveCustomerAction(@Valid Customer customer, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				System.out.println("Returning custSave.jsp page");
				return "custSave";
			}
			System.out.println("Returning custSaveSuccess.jsp page");
			model.addAttribute("customer", customer);
			customers.put(customer.getEmail(), customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "custSaveSuccess";
	}

}