package com.stevens.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersonMappedSuperClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long personId;

  @Column(name = "name")
  String name;

  public PersonMappedSuperClass() {

  }

  public PersonMappedSuperClass(String name) {
    this.name = name;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}