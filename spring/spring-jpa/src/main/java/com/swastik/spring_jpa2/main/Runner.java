package com.swastik.spring_jpa2.main;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.swastik.spring_jpa2.config.JpaPersistance;
import com.swastik.spring_jpa2.dao.EmployeeService;
import com.swastik.spring_jpa2.model.Address;
import com.swastik.spring_jpa2.model.Certification;
import com.swastik.spring_jpa2.model.Employee;
import com.swastik.spring_jpa2.model.TechStack;

public class Runner {

    public static void main(String[] args) {

        try {
            Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(JpaPersistance.class);
            ctx.refresh();

            EmployeeService empService = (EmployeeService) ctx.getBean("employeeService");

            Employee e = new Employee("Abhishek", "Sales", 3 * 1000, "Hyderabad",
                    new Address("24th Blvd", "Chicago", "IL", "US", 312432),
                    Arrays.asList(new Certification("JAVA_POJO", "Technical"), new Certification("PMP", "Management")));

            TechStack t1 = new TechStack("JV", "JAVA");
            TechStack t2 = new TechStack("PY", "PYTHON");

            e.addTechStacks(t1);
            e.addTechStacks(t2);
            empService.saveEmployee(e);

            Employee e1 = new Employee("Sith", "MN", 5 * 1000, "Miami",
                    new Address("4th Main Street", "Miami", "Fl", "US", 482015),
                    Arrays.asList(new Certification("IT", "Technical"), new Certification("PMP", "Management")));

            TechStack t3 = new TechStack("JV", "JAVA");
            TechStack t4 = new TechStack("AN", "Angular");

            e1.addTechStacks(t3);
            e1.addTechStacks(t4);
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
