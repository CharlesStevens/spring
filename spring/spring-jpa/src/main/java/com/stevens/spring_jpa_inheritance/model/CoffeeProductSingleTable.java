package com.stevens.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("coffee")
public class CoffeeProductSingleTable extends ProductSingleTable {

  @Column
  String coffeeName;

  public CoffeeProductSingleTable() {

  }

  public CoffeeProductSingleTable(String productName, String coffeeName) {
    super(productName);
    this.coffeeName = coffeeName;
  }

  public String getCoffeeName() {
    return coffeeName;
  }

  public void setCoffeeName(String coffeeName) {
    this.coffeeName = coffeeName;
  }
}
