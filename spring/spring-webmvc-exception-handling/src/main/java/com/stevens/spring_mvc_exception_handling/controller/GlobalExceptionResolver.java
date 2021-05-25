package com.stevens.spring_mvc_exception_handling.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.stevens.spring_mvc_exception_handling.exception.EmployeeNotFoundException;

@Component
public class GlobalExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
			@Nullable Object handler, Exception ex) {
		if (ex instanceof EmployeeNotFoundException) {
			System.out.println("Inside GlobalExceptionResolver");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("exception", ex);
			modelAndView.addObject("url", request.getRequestURL());
			modelAndView.setViewName("error");
			return modelAndView;
		}
		return null;
	}

}
