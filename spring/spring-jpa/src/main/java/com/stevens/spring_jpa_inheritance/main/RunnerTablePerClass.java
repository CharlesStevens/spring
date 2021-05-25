package com.stevens.spring_jpa_inheritance.main;

import com.stevens.spring_jpa_inheritance.config.JpaPersistence;
import com.stevens.spring_jpa_inheritance.model.BikeTablePerClass;
import com.stevens.spring_jpa_inheritance.repo.BikeTablePerClassRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunnerTablePerClass {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(
        JpaPersistence.class);
    ctx.refresh();

    BikeTablePerClassRepo bikeTablePerClassRepo = (BikeTablePerClassRepo) ctx
        .getBean("bikeTablePerClassRepo");
    bikeTablePerClassRepo.save(new BikeTablePerClass("RE", "Thunderbird"));
  }

}
