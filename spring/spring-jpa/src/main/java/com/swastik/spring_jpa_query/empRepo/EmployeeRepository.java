package com.swastik.spring_jpa_query.empRepo;

import com.swastik.spring_jpa_query.empModel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
