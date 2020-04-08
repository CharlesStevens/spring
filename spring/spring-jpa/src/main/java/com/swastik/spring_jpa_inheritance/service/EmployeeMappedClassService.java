package com.swastik.spring_jpa_inheritance.service;

import com.swastik.spring_jpa_inheritance.model.EmployeeMappedSuperClass;
import com.swastik.spring_jpa_inheritance.repo.EmployeeMappedClassRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMappedClassService {

  @Autowired
  EmployeeMappedClassRepository personRepo;

  public void save(EmployeeMappedSuperClass p) {
    personRepo.save(p);
  }

  public List<EmployeeMappedSuperClass> getPersons() {
    return personRepo.findAll();
  }
}
