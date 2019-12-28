package com.stevens.spring.annotations.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class AppProfile {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.stevens.spring.annotations.profile");
    ctx.refresh();

    CustomBean customBean = (CustomBean) ctx.getBean(CustomBean.class);
    CustomBeanDifferent customBeanDifferent = (CustomBeanDifferent) ctx
        .getBean("customBeanDifferent");

    customBean.execute();
    customBeanDifferent.execute();
  }
}

@Configuration
class DevConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    System.out.println("Injected SourcePlaceHolder");
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  @Profile("DEV")
  public CustomBean customBean() {
    return new CustomBean("DEV");
  }
}

@Configuration
class GenericConfig {

  @Bean
  @Profile("Test")
  public CustomBean customBean() {
    return new CustomBean("Test");
  }

  @Bean
  public CustomBeanDifferent customBeanDifferent() {
    return new CustomBeanDifferent("Generic");
  }
}


class CustomBean {

  String profiles;

  public CustomBean(String profile) {
    this.profiles = profile;
  }

  public void execute() {
    System.out.println("name of profile : " + profiles);
  }
}


class CustomBeanDifferent {

  String profiles;

  public CustomBeanDifferent(String profile) {
    this.profiles = profile;
  }

  public void execute() {
    System.out.println("name of profile : " + profiles);
  }
}