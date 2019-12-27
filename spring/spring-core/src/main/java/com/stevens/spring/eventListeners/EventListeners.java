package com.stevens.spring.eventListeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

public class EventListeners {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.stevens.spring.eventListeners");

    System.out.println("Refreshing context");
    ctx.refresh();
    System.out.println("Stopping context");
    ctx.stop();
    System.out.println("Closing context");
    ctx.close();
  }

}

@Component
class CtxRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("application refreshed");
  }
}

@Component
class CtxStartedListener implements ApplicationListener<ContextStartedEvent> {

  @Override
  public void onApplicationEvent(ContextStartedEvent event) {
    System.out.println("application started");
  }
}

@Component
class CtxStoppedListener implements ApplicationListener<ContextStoppedEvent> {

  @Override
  public void onApplicationEvent(ContextStoppedEvent event) {
    System.out.println("application stopped");
  }
}
@Component
class CtxClosedListener implements ApplicationListener<ContextClosedEvent> {

  @Override
  public void onApplicationEvent(ContextClosedEvent event) {
    System.out.println("application closed");
  }
}
