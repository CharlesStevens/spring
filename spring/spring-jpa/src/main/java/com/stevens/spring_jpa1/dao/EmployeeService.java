package com.stevens.spring_jpa1.dao;

import com.stevens.spring_jpa1.model.Employee;
import com.stevens.spring_jpa1.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
