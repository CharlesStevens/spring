package com.stevens.spring_jpa_inheritance.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.stevens.spring_jpa_inheritance.repo"})
@ComponentScan(basePackages = {"com.stevens.spring_jpa_inheritance"})
@PropertySource("classpath:application.properties")
public class JpaPersistence {

  @Autowired
  Environment env;

  @Bean
  DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
    dataSource.setUrl(env.getRequiredProperty("db.url"));
    dataSource.setUsername(env.getRequiredProperty("db.username"));
    dataSource.setPassword(env.getRequiredProperty("db.password"));
    System.out.println("DataSource Bean initialized " + dataSource.toString());
    return dataSource;
  }

  @Bean
  LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    // Properties props = hibernateProps();
    entityManagerFactory.setDataSource(dataSource());
    entityManagerFactory.setPersistenceUnitName("Hibernate");
    entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    entityManagerFactory.setPackagesToScan("com.stevens.spring_jpa_inheritance.model");

    Properties props = new Properties();
    props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
    props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
    props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

    entityManagerFactory.setJpaProperties(props);
    return entityManagerFactory;
  }

  @Bean
  JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory);
    System.out.println("################### Trn manager");
    return txManager;
  }

}
