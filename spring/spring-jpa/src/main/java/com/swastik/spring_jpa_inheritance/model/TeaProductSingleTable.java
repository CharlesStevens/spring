package com.swastik.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("tea")
public class TeaProductSingleTable extends ProductSingleTable {

  @Column
  String teaName;

  public TeaProductSingleTable() {

  }

  public TeaProductSingleTable(String productName, String teaName) {
    super(productName);
    this.teaName = teaName;
  }

  public String getCoffeeName() {
    return teaName;
  }

  public void setTeaName(String teaName) {
    this.teaName = teaName;
  }
}
