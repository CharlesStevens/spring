package com.swastik.spring_jpa2.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swastik.spring_jpa2.model.Employee;
import com.swastik.spring_jpa2.model.TechStack;
import com.swastik.spring_jpa2.service.TechStackRepository;

@Service
public class TechStackService {

	@Autowired
	TechStackRepository repo;

	public List<TechStack> listTechStacks() {
		return repo.findAll();
	}

	public boolean addEmployee(TechStack tech, Employee e) {
		List<TechStack> stacks = repo.findAll();
		for (TechStack ts : stacks) {
			if (ts.getStack_id().equalsIgnoreCase(tech.getStack_id())) {
				ts.addEmployees(e);
				repo.save(ts);
				return true;
			}
		}

		return false;

	}
}
