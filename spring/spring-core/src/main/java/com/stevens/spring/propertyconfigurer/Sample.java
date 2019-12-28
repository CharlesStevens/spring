package com.stevens.spring.propertyconfigurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;

class PropertySample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Config.class);
        ctx.refresh();
        ClassA a = (ClassA) ctx.getBean("classA");
        a.execute();
    }
}

@Component
class ClassA {
    @Value("${prp.key}")
    String prpVal;
    @Autowired
    Environment env;
    @Autowired
    ClassB classB;


//    public ClassA(@Autowired ClassB classB, @Value("${prp.key}") String val, @Autowired Environment env) {
//        this.classB = classB;
//        this.prpVal = val;
//        this.env = env;
//    }

    public void execute() {
        String val = env.getProperty("prp.see");
        System.out.println("Has Property prpa.key : "+ env.containsProperty("prp.key"));
        System.out.println("ValueOf prp Key is : " + prpVal + " and prp see is : " + val );
    }

}

@Component
class ClassB {

    public void execute() {

    }

}

@Configuration
@ComponentScan("com.sample.spring_core.property")
@PropertySource(value = "${spring.config.location}", ignoreResourceNotFound = false)
class Config {

//    @Bean
//    public static PropertyPlaceholderConfigurer getProperty() {
//        PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
////        Resource[] resources = new FileSystemResource[]
////                {new FileSystemResource("C:\\Users\\abhishek.sharma4\\Downloads\\faa.properties")};
////        cfg.setLocations(resources);
//        return cfg;
//    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer getProperties() {
//        PropertySourcesPlaceholderConfigurer cfg = new PropertySourcesPlaceholderConfigurer();
//        Resource[] resources = new ClassPathResource[]
//                {new ClassPathResource("foo.properties")};
//            cfg.setLocations(resources);
//        return cfg;
//    }

}

