package com.stevens.spring_jpa_inheritance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AnimalJoinedTable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long animalId;

  @Column
  String animalType;

  public AnimalJoinedTable() {
  }

  public AnimalJoinedTable(String animalType) {
    this.animalType = animalType;
  }

  public Long getAnimalId() {
    return animalId;
  }

  public void setAnimalId(Long animalId) {
    this.animalId = animalId;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }
}
