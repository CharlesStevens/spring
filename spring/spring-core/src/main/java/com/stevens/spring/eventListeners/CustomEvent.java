package com.stevens.spring.eventListeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomEvent extends ApplicationEvent {

  public CustomEvent(CustomEventPublisher source) {
    super(source);
  }

  public String toString() {
    return "customEvent";
  }
}

@Component
class CustomEventPublisher implements ApplicationEventPublisherAware {

  ApplicationEventPublisher publisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.publisher = applicationEventPublisher;
  }

  public void publish() {
    CustomEvent ce = new CustomEvent(this);
    publisher.publishEvent(ce);
  }

}

@Component
class CustomEventHandler implements ApplicationListener<CustomEvent> {

  @Override
  public void onApplicationEvent(CustomEvent event) {
    System.out.println("In OnApplicationEvent : " + event.toString());
  }
}

class MainApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.stevens.spring.eventListeners");
    ctx.refresh();

    CustomEventPublisher publisher = (CustomEventPublisher) ctx.getBean("customEventPublisher");
    System.out.println("Calling publish on custompublisher");
    publisher.publish();
  }
}

@Component
class Employee {

}