package com.stevens.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "catId")
public class CatJoinedTable extends AnimalJoinedTable{

  @Column
  String catName;

  public CatJoinedTable() {
  super();
  }

  public CatJoinedTable( String animalType, String catName) {
    super(animalType);
    this.catName = catName;
  }

  public String getCatName() {
    return catName;
  }

  public void setCatName(String catName) {
    this.catName = catName;
  }
}
