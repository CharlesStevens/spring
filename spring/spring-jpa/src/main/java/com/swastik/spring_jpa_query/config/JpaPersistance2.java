package com.swastik.spring_jpa_query.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages =
    "com.swastik.spring_jpa_query.empRepo", entityManagerFactoryRef = "entityManagerFactory2",
    transactionManagerRef = "transactionManager2")
@PropertySource("classpath:application.properties")
public class JpaPersistance2 {

  @Autowired
  Environment env;

  @Bean(name = "dataSource2")
  DataSource dataSource2() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("newdb.driver"));
    dataSource.setUrl(env.getRequiredProperty("newdb.url"));
    dataSource.setUsername(env.getRequiredProperty("newdb.username"));
    dataSource.setPassword(env.getRequiredProperty("newdb.password"));
    System.out.println("DataSource Bean initialized " + dataSource.toString());
    return dataSource;
  }

  @Bean(name = "entityManagerFactory2")
  LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    // Properties props = hibernateProps();
    DataSource ds = dataSource2();
    entityManagerFactory.setDataSource(ds);
    entityManagerFactory.setPersistenceUnitName("new-hibernate");
    entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    entityManagerFactory.setPackagesToScan("com.swastik.spring_jpa_query.empModel");

    Properties props = new Properties();
    props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
    props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    props.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
//    props.setProperty("hibernate.type", env.getProperty("hibernate.type"));
    props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    props.setProperty("hibernate.naming-strategy", env.getProperty("hibernate.naming-strategy"));
//    props.setProperty("logging.level.org.hibernate.type.descriptor.sql",
//        env.getProperty("logging.level.org.hibernate.type.descriptor.sql"));

    entityManagerFactory.setJpaProperties(props);
    return entityManagerFactory;
  }

  @Bean(name = "transactionManager2")
  PlatformTransactionManager transactionManager2() {
    JpaTransactionManager txManager = new JpaTransactionManager();
    LocalContainerEntityManagerFactoryBean em = entityManagerFactory2();
    txManager.setEntityManagerFactory(em.getObject());
    return txManager;
  }

}
