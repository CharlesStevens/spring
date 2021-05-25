package com.stevens.spring_jpa2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stevens.spring_jpa2.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
