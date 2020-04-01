package com.swastik.spring_jpa2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.spring_jpa2.model.Employee;
import com.swastik.spring_jpa2.service.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public void saveEmployee(Employee e) {
		empRepository.save(e);
	}

	public Iterable<Employee> listEmployees() {
		return empRepository.findAll();
	}

}
