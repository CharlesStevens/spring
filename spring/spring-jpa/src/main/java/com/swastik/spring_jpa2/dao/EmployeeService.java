package com.swastik.spring_jpa2.dao;

import java.util.List;
import java.util.Set;

import com.swastik.spring_jpa2.service.TechStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.spring_jpa2.model.Employee;
import com.swastik.spring_jpa2.model.TechStack;
import com.swastik.spring_jpa2.service.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    @Autowired
    TechStackRepository techStackRepository;


    public void saveEmployee(Employee e) {
        Set<TechStack> tags = e.getTechStacks();

        List<TechStack> persistedTags = techStackRepository.findAll();
        boolean tagPersited = false;

        for (TechStack t : tags) {
            if (persistedTags.stream().filter(s -> s.getStack_id().equals(t.getStack_id())).findAny().isPresent()) {
                techStackRepository.save(t);
                tagPersited = true;
            }
        }

        if (!tagPersited)
            empRepository.save(e);
    }

    public Iterable<Employee> listEmployees() {
        return empRepository.findAll();
    }

}
