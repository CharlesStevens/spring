package com.swastik.spring_jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swastik.spring_jpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
