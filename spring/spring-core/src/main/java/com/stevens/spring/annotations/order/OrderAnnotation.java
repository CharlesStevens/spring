package com.stevens.spring.annotations.order;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

interface Class {

  public void doSomething();
}

public class OrderAnnotation {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.stevens.spring.annotations.order");
    ctx.refresh();

    MainRunnerApp runnerApp = (MainRunnerApp) ctx.getBean("mainRunnerApp");
    runnerApp.execute();

    ctx.stop();
    ctx.close();
  }
}

@Component
class MainRunnerApp {

  List<Class> components;

  @Autowired
  public MainRunnerApp(List<Class> components) {
    this.components = components;
  }

  public void execute() {
    for (Class c : components) {
      c.doSomething();
    }
  }
}

@Component
@Order(100)
class ClassA implements Class{

  public void doSomething() {
    System.out.println("Order : 100");
  }
}

@Component
@Order(-99)
class ClassD implements Class{

  public void doSomething() {
    System.out.println("Order : -99");
  }
}

@Component
@Order(-99)
class ClassC implements Class{

  public void doSomething() {
    System.out.println("Order : 0");
  }
}

@Component
@Order(4)
class ClassB implements Class{

  public void doSomething() {
    System.out.println("Order : 4");
  }
}
