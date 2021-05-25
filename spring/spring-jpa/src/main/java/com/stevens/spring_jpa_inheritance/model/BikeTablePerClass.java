package com.stevens.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "biketableperclass")
public class BikeTablePerClass extends VehicleTablePerClass {

  @Column
  String vehicleName;

  public BikeTablePerClass() {
  }

  public BikeTablePerClass(String manufacturer, String vehicleName) {
    super(manufacturer);
    this.vehicleName = vehicleName;
  }


  public String getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(String vehicleName) {
    this.vehicleName = vehicleName;
  }
}
