package com.swastik.spring_jpa.dao;

import com.swastik.spring_jpa.model.Employee;

public interface EmployeeService {

	public void saveEmployee(Employee e);

	public Iterable<Employee> listEmployees();
}
