package com.swastik.spring_jpa_query.service;

import com.swastik.spring_jpa_query.empModel.Employee;
import com.swastik.spring_jpa_query.empRepo.EmployeeRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository repo;

  public void saveEmployee(Employee e) {
    repo.save(e);
  }

  @Transactional
  public void saveAllEmployee(List<Employee> e) {
    repo.saveAll(e);
  }
}