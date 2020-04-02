package com.swastik.spring_jpa2.dao;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.spring_jpa2.model.Employee;
import com.swastik.spring_jpa2.model.TechStack;
import com.swastik.spring_jpa2.service.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	// @Autowired
	// TechStackRepository tsRepo;

	public void saveEmployee(Employee e) {

		Iterable<Employee> ee = empRepository.findAll();

		Iterator<Employee> it = ee.iterator();
		while (it.hasNext()) {
			Employee e1 = it.next();
			for (TechStack ts1 : e1.getTechStacks()) {
				if (e.getTechStacks().stream().filter(t -> t.getStack_id().equals(ts1.getStack_id())).findAny()
						.isPresent()) {
					e.getTechStacks().remove(e.getTechStacks().stream()
							.filter(t -> t.getStack_id().equals(ts1.getStack_id())).findAny().get());
					e.addTechStacks(ts1);
				}
			}
		}

		empRepository.save(e);
	}

	public Iterable<Employee> listEmployees() {
		return empRepository.findAll();
	}

}
