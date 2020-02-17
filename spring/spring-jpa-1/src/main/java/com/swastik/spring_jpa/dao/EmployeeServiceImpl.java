package com.swastik.spring_jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.spring_jpa.model.Employee;
import com.swastik.spring_jpa.service.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	public void saveEmployee(Employee e) {
		System.out.println("Saving employee");
		Employee e1 = empRepository.save(e);
		System.out.println(e1.getEmp_id() + " Saved");
	}

	public Iterable<Employee> listEmployees() {
		return empRepository.findAll();
	}
}
