package com.stevens.spring_jpa_inheritance.main;

import com.stevens.spring_jpa_inheritance.config.JpaPersistence;
import com.stevens.spring_jpa_inheritance.model.CoffeeProductSingleTable;
import com.stevens.spring_jpa_inheritance.model.EmployeeMappedSuperClass;
import com.stevens.spring_jpa_inheritance.model.TeaProductSingleTable;
import com.stevens.spring_jpa_inheritance.service.CoffeeProductSingleTableService;
import com.stevens.spring_jpa_inheritance.service.EmployeeMappedClassService;
import com.stevens.spring_jpa_inheritance.service.TeaProductSingleTableService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnerSingleTable {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(JpaPersistence.class);
    ctx.refresh();

    TeaProductSingleTableService teaService = (TeaProductSingleTableService) ctx
        .getBean("teaProductSingleTableService");
    CoffeeProductSingleTableService coffeeService = (CoffeeProductSingleTableService) ctx
        .getBean("coffeeProductSingleTableService");

//    teaService.save(new TeaProductSingleTable("Abhishek", "CTX"));
    coffeeService.save(new CoffeeProductSingleTable("Coffee","Nescafe"));

//    teaService.getProducts().forEach(t -> System.out.println(t));
    coffeeService.getCoffeeProduct().forEach(t -> System.out.println(t));
  }
}
