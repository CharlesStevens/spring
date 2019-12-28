package com.stevens.spring.propertyconfigurer;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

public class PropertySourceSample {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.stevens.spring.propertyconfigurer");
    ctx.refresh();

    System.out.println("Context Started");
    BeanClass beanClass = (BeanClass) ctx.getBean("beanClass");

    ctx.stop();
    System.out.println("Context Stopped");
  }
}

@Configuration
class PropertyConfig {

  @Bean
  public PropertySourcesPlaceholderConfigurer configurer() {
    PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
    p.setLocations(new ClassPathResource("trainDetails.properties"));
    return p;
  }
}

@Component
class BeanClass implements InitializingBean {

  @Value("${trainName}")
  String trainName;

  @PostConstruct
  public void init() {
    System.out.println("PostConstruct Train Name is : " + trainName);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("afterPropertiesSet Train Name is : " + trainName);
  }
}
