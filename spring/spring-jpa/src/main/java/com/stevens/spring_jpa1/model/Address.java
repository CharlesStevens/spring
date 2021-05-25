package com.stevens.spring_jpa1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
  Long add_id;
  
  @Column(name = "street_name")
  String street_name;

  public Address() {
  }

  public Address(String street_name) {
    this.street_name = street_name;
  }

  public Long getAdd_id() {
    return add_id;
  }

  public void setAdd_id(Long add_id) {
    this.add_id = add_id;
  }

  public String getStreet_name() {
    return street_name;
  }

  public void setStreet_name(String street_name) {
    this.street_name = street_name;
  }
}
