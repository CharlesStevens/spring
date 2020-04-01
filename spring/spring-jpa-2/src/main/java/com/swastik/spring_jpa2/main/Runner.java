package com.swastik.spring_jpa2.main;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.swastik.spring_jpa2.config.JpaPersistance;
import com.swastik.spring_jpa2.dao.EmployeeService;
import com.swastik.spring_jpa2.dao.TechStackService;
import com.swastik.spring_jpa2.model.Address;
import com.swastik.spring_jpa2.model.Certification;
import com.swastik.spring_jpa2.model.Employee;
import com.swastik.spring_jpa2.model.TechStack;
import com.swastik.spring_jpa2.service.PostRepository;

public class Runner {

	public static void main(String[] args) {

		try {
			Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
			ctx.register(JpaPersistance.class);
			ctx.refresh();

			EmployeeService empService = (EmployeeService) ctx.getBean("employeeService");
			PostRepository postRepository = (PostRepository) ctx.getBean("postRepository");
			TechStackService techService = (TechStackService) ctx.getBean("techStackService");

			// // Create a Post
			// Post post = new Post("Hibernate Many to Many Example with Spring Boot",
			// "Learn how to map a many to many relationship using hibernate",
			// "Entire Post content with Sample code");
			//
			// Post post1 = new Post("hibernate spring cast", "some learn", "some other
			// post");
			//
			// // Create two tags
			// Tag tag1 = new Tag("Spring Boot");
			// Tag tag2 = new Tag("Hibernate");
			//
			// // Add tag references in the post
			// post.getTags().add(tag1);
			// post.getTags().add(tag2);
			//
			// // Add post reference in the tags
			// tag1.getPosts().add(post);
			// tag2.getPosts().add(post);
			//
			// postRepository.save(post);
			//
			// Tag tag4 = new Tag("Spring Boot");
			// Tag tag3 = new Tag("someother");
			//
			// post1.getTags().add(tag4);
			// post1.getTags().add(tag3);
			//
			// tag4.getPosts().add(post1);
			// tag3.getPosts().add(post1);
			//
			// postRepository.save(post1);

			// Employee e = new Employee("Abhishek", "Sales", 3 * 1000, "Hyderabad",
			// new Address("24th Blvd", "Chicago", "IL", "US", 312432),
			// Arrays.asList(new Certification("JAVA_POJO", "Technical"), new
			// Certification("PMP", "Management")));

			// TechStack t1 = new TechStack("JV", "JAVA");
			// TechStack t2 = new TechStack("PY", "PYTHON");
			// t1.addEmployees(e);
			// t2.addEmployees(e);

			// System.out.println("############### " + t1.equals(t2));
			// System.out.println("############### " + t1.getEmployees());
			// System.out.println("############### " + t1.hashCode() + " " + t2.hashCode());

			Employee e1 = new Employee("John", "IT", 5 * 1000, "Miami",
					new Address("4th Main Street", "Miami", "Fl", "US", 482015),
					Arrays.asList(new Certification("IT", "Technical"), new Certification("PMP", "Management")));

			TechStack t3 = new TechStack("JV", "JAVA");
			TechStack t4 = new TechStack("AN", "Angular");

			boolean b1 = techService.addEmployee(t3, e1);
			boolean b2 = techService.addEmployee(t4, e1);

			if (!b1) {
				t3.addEmployees(e1);
			}

			if (!b2) {
				t4.addEmployees(e1);
			}

			// t3.addEmployees(e1);
			// t4.addEmployees(e1);

			// System.out.println("############### " + t3.equals(t4));
			// System.out.println("############### " + t3.getEmployees());
			// System.out.println("############### " + t3.hashCode() + " " + t4.hashCode());
			// System.out.println("############### " + e.equals(e1));
			// System.out.println("############### " + e.hashCode() + " " + e1.hashCode());
			// empService.saveEmployee(e);
			empService.saveEmployee(e1);

			Iterable<Employee> e11 = empService.listEmployees();
			e11.forEach(t -> System.out.println("Saved employee with id " + t.toString()));

			System.out.println("Employee saved");

			ctx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
