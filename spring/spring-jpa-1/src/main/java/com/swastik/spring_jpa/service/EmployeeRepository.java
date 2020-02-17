package com.swastik.spring_jpa.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.swastik.spring_jpa.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
