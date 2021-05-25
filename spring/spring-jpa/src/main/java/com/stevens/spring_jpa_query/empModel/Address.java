package com.stevens.spring_jpa_query.empModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long addressId;
  @Column
  String residingPersonName;
  @Column
  String city;
  @Column
  String street;

  public Address() {
  }

  public Address(String residingPersonName, String city, String street) {
    this.residingPersonName = residingPersonName;
    this.city = city;
    this.street = street;
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public String getResidingPersonName() {
    return residingPersonName;
  }

  public void setResidingPersonName(String residingPersonName) {
    this.residingPersonName = residingPersonName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @Override
  public String toString() {
    return "Address{" +
        "addressId=" + addressId +
        ", residingPersonName='" + residingPersonName + '\'' +
        ", city='" + city + '\'' +
        ", column='" + street + '\'' +
        '}';
  }
}
