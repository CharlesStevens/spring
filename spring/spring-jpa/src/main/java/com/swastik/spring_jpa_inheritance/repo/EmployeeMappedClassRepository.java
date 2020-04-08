package com.swastik.spring_jpa_inheritance.repo;

import com.swastik.spring_jpa_inheritance.model.EmployeeMappedSuperClass;
import com.swastik.spring_jpa_inheritance.model.PersonMappedSuperClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMappedClassRepository extends JpaRepository<EmployeeMappedSuperClass, Long> {

}
