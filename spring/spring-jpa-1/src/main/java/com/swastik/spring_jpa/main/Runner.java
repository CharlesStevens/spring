package com.swastik.spring_jpa.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.swastik.spring_jpa.config.JpaPersistance;
import com.swastik.spring_jpa.dao.EmployeeService;
import com.swastik.spring_jpa.model.Employee;

public class Runner {

	public static void main(String[] args) {

		try {
			Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
			ctx.register(JpaPersistance.class);
			ctx.refresh();

			EmployeeService empService = (EmployeeService) ctx.getBean("employeeServiceImpl");
			Employee e = new Employee(1200, "Abhishek", "IT", 70000L, "Bangalore");
			empService.saveEmployee(e);

			System.out.println("Employee saved");

			Iterable<Employee> iterable = empService.listEmployees();
			iterable.forEach(t -> System.out.println(t.getEmp_id() + " " + t.getEmp_name()));
			ctx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
