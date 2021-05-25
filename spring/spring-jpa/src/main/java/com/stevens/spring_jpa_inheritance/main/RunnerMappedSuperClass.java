package com.stevens.spring_jpa_inheritance.main;

import com.stevens.spring_jpa_inheritance.config.JpaPersistence;
import com.stevens.spring_jpa_inheritance.model.EmployeeMappedSuperClass;
import com.stevens.spring_jpa_inheritance.service.EmployeeMappedClassService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnerMappedSuperClass {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(JpaPersistence.class);
    ctx.refresh();

    EmployeeMappedClassService service = (EmployeeMappedClassService) ctx
        .getBean("employeeMappedClassService");
    service.save(new EmployeeMappedSuperClass("Abhishek", "CTX"));

    service.getPersons().forEach(t -> System.out.println(t));
  }

}
