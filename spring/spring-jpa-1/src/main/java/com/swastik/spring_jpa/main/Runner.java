package com.swastik.spring_jpa.main;

import com.swastik.spring_jpa.config.JpaPersistance;
import com.swastik.spring_jpa.dao.EmployeeService;
import com.swastik.spring_jpa.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

  public static void main(String[] args) {

    try {
      Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
      ctx.register(JpaPersistance.class);
      ctx.refresh();

      EmployeeService empService = (EmployeeService) ctx.getBean("employeeService");

      Employee e = new Employee("Abhishek", "Sales", 3*1000, "Hyderabad");
      empService.saveEmployee(e);
//
//      for (int i = 0; i < 1; i++) {
//        Employee e = new Employee("Abhishek", "Sales", i*1000, "Hyderabad");
//        empService.saveEmployee(e);
//      }


      Iterable<Employee> e1 = empService.listEmployees();
      e1.forEach(t -> System.out.println("Saved employee with id " + t.getEmp_id()));

      System.out.println("Employee saved");

//			AddressService addService = (AddressService) ctx.getBean("addressService");
//			Address a = new Address("Kormangla");
//			addService.saveAddress(a);
//
//			System.out.println("Address saved");

//			Iterable<Employee> iterable = empService.listEmployees();
//			iterable.forEach(t -> System.out.println(t.getEmp_id() + " " + t.getEmp_name()));
      ctx.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
