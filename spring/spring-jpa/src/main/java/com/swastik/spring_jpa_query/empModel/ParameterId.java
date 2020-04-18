package com.swastik.spring_jpa_query.empModel;

import java.io.Serializable;
import java.util.Objects;

public class ParameterId implements Serializable {

  String paramName;
  Long paramId;

  public ParameterId() {
  }

  public ParameterId(String paramName, Long paramId) {
    this.paramName = paramName;
    this.paramId = paramId;
  }

  public String getParamName() {
    return paramName;
  }

  public void setParamName(String paramName) {
    this.paramName = paramName;
  }

  public Long getParamId() {
    return paramId;
  }

  public void setParamId(Long paramId) {
    this.paramId = paramId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ParameterId)) {
      return false;
    }
    ParameterId that = (ParameterId) o;
    return paramName.equals(that.paramName) &&
        paramId.equals(that.paramId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paramName, paramId);
  }
}
