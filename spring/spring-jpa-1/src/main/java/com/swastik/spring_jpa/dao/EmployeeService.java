package com.swastik.spring_jpa.dao;

import com.swastik.spring_jpa.model.Employee;
import com.swastik.spring_jpa.service.EmployeeRepository;
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
