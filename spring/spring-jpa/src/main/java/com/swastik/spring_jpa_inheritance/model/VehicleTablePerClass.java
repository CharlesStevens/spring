package com.swastik.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "vehicletableperclass")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VehicleTablePerClass {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  Long vehicleId;

  @Column
  String manufacturer;

  public VehicleTablePerClass() {
  }

  public VehicleTablePerClass(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
}
