package com.stevens.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class EmployeeMappedSuperClass extends PersonMappedSuperClass {

  @Column(name = "company")
  String company;

  public EmployeeMappedSuperClass() {

  }

  public EmployeeMappedSuperClass(String name, String company) {
    super(name);
    this.company = company;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  @Override
  public String toString() {
    return "EmployeeMappedSuperClass{" +
        "company='" + company + '\'' +
        ", personId=" + personId +
        ", name='" + name + '\'' +
        '}';
  }
}
