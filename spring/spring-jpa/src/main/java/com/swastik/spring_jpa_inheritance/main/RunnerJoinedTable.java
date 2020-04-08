package com.swastik.spring_jpa_inheritance.main;

import com.swastik.spring_jpa_inheritance.config.JpaPersistence;
import com.swastik.spring_jpa_inheritance.model.CatJoinedTable;
import com.swastik.spring_jpa_inheritance.service.CatJoinedTableService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnerJoinedTable {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(JpaPersistence.class);
    ctx.refresh();

    CatJoinedTableService an = (CatJoinedTableService) ctx.getBean("catJoinedTableService");

    an.save(new CatJoinedTable("cat", "hectar"));

    an.getAnimals().forEach(t -> System.out.println(t.toString()));
  }

}
