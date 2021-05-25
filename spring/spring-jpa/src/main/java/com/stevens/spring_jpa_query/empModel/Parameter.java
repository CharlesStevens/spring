package com.stevens.spring_jpa_query.empModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass(ParameterId.class)
public class Parameter {

  @Id
  String paramName;
  @Id
  Long paramId;
  @Column
  String paramDesc;
  @Column
  Integer paramValue;


}
