package com.stevens.spring_mvc_exception_handling.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee is not present in Database")
public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 4997265274955791765L;

	public EmployeeNotFoundException(int id) {
		super("Employee not found for id : " + id);
	}
}
