package com.swastik.spring_jpa_query.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "flightdata")
@NamedQuery(name = "FlightData.fetchOnAirport", query = "select f from FlightData  limit 10")
public class FlightData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long recordId;
  @Column
  Integer year;
  @Column
  Integer month;
  @Column
  String carrier;
  @Column(name = "carrier_name")
  String carrierName;
  @Column
  String airport;
  @Column
  String airport_name;
  @Column
  Integer arr_flights;
  @Column
  Integer arr_del15;
  @Column
  Double carrier_ct;
  @Column
  Double weather_ct;
  @Column
  Double nas_ct;
  @Column
  Double security_ct;
  @Column
  Double late_aircraft_ct;
  @Column
  Integer arr_cancelled;
  @Column
  Integer arr_diverted;
  @Column
  Integer arr_delay;
  @Column
  Integer carrier_delay;
  @Column
  Integer weather_delay;
  @Column
  Integer nas_delay;
  @Column
  Integer security_delay;
  @Column
  Integer late_aircraft_delay;

  public FlightData() {
  }

  public FlightData(Integer year, Integer month, String carrier, String carrier_name,
      String airport,
      String airport_name, Integer arr_flights, Integer arr_del15, Double carrier_ct,
      Double weather_ct, Double nas_ct, Double security_ct, Double late_aircraft_ct,
      Integer arr_cancelled, Integer arr_diverted, Integer arr_delay, Integer carrier_delay,
      Integer weather_delay, Integer nas_delay, Integer security_delay,
      Integer late_aircraft_delay) {
    this.year = year;
    this.month = month;
    this.carrier = carrier;
    this.carrierName = carrier_name;
    this.airport = airport;
    this.airport_name = airport_name;
    this.arr_flights = arr_flights;
    this.arr_del15 = arr_del15;
    this.carrier_ct = carrier_ct;
    this.weather_ct = weather_ct;
    this.nas_ct = nas_ct;
    this.security_ct = security_ct;
    this.late_aircraft_ct = late_aircraft_ct;
    this.arr_cancelled = arr_cancelled;
    this.arr_diverted = arr_diverted;
    this.arr_delay = arr_delay;
    this.carrier_delay = carrier_delay;
    this.weather_delay = weather_delay;
    this.nas_delay = nas_delay;
    this.security_delay = security_delay;
    this.late_aircraft_delay = late_aircraft_delay;
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = airport;
  }

  public String getAirport_name() {
    return airport_name;
  }

  public void setAirport_name(String airport_name) {
    this.airport_name = airport_name;
  }

  public Integer getArr_flights() {
    return arr_flights;
  }

  public void setArr_flights(Integer arr_flights) {
    this.arr_flights = arr_flights;
  }

  public Integer getArr_del15() {
    return arr_del15;
  }

  public void setArr_del15(Integer arr_del15) {
    this.arr_del15 = arr_del15;
  }

  public Double getCarrier_ct() {
    return carrier_ct;
  }

  public void setCarrier_ct(Double carrier_ct) {
    this.carrier_ct = carrier_ct;
  }

  public Double getWeather_ct() {
    return weather_ct;
  }

  public void setWeather_ct(Double weather_ct) {
    this.weather_ct = weather_ct;
  }

  public Double getNas_ct() {
    return nas_ct;
  }

  public void setNas_ct(Double nas_ct) {
    this.nas_ct = nas_ct;
  }

  public Double getSecurity_ct() {
    return security_ct;
  }

  public void setSecurity_ct(Double security_ct) {
    this.security_ct = security_ct;
  }

  public Double getLate_aircraft_ct() {
    return late_aircraft_ct;
  }

  public void setLate_aircraft_ct(Double late_aircraft_ct) {
    this.late_aircraft_ct = late_aircraft_ct;
  }

  public Integer getArr_cancelled() {
    return arr_cancelled;
  }

  public void setArr_cancelled(Integer arr_cancelled) {
    this.arr_cancelled = arr_cancelled;
  }

  public Integer getArr_diverted() {
    return arr_diverted;
  }

  public void setArr_diverted(Integer arr_diverted) {
    this.arr_diverted = arr_diverted;
  }

  public Integer getArr_delay() {
    return arr_delay;
  }

  public void setArr_delay(Integer arr_delay) {
    this.arr_delay = arr_delay;
  }

  public Integer getCarrier_delay() {
    return carrier_delay;
  }

  public void setCarrier_delay(Integer carrier_delay) {
    this.carrier_delay = carrier_delay;
  }

  public Integer getWeather_delay() {
    return weather_delay;
  }

  public void setWeather_delay(Integer weather_delay) {
    this.weather_delay = weather_delay;
  }

  public Integer getNas_delay() {
    return nas_delay;
  }

  public void setNas_delay(Integer nas_delay) {
    this.nas_delay = nas_delay;
  }

  public Integer getSecurity_delay() {
    return security_delay;
  }

  public void setSecurity_delay(Integer security_delay) {
    this.security_delay = security_delay;
  }

  public Integer getLate_aircraft_delay() {
    return late_aircraft_delay;
  }

  public void setLate_aircraft_delay(Integer late_aircraft_delay) {
    this.late_aircraft_delay = late_aircraft_delay;
  }

  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  @Override
  public String toString() {
    return "FlightData{" +
        "recordId=" + recordId +
        ", year=" + year +
        ", month=" + month +
        ", carrier='" + carrier + '\'' +
        ", carrier_name='" + carrierName + '\'' +
        ", airport='" + airport + '\'' +
        ", airport_name='" + airport_name + '\'' +
        ", arr_flights=" + arr_flights +
        ", arr_del15=" + arr_del15 +
        ", carrier_ct=" + carrier_ct +
        ", weather_ct=" + weather_ct +
        ", nas_ct=" + nas_ct +
        ", security_ct=" + security_ct +
        ", late_aircraft_ct=" + late_aircraft_ct +
        ", arr_cancelled=" + arr_cancelled +
        ", arr_diverted=" + arr_diverted +
        ", arr_delay=" + arr_delay +
        ", carrier_delay=" + carrier_delay +
        ", weather_delay=" + weather_delay +
        ", nas_delay=" + nas_delay +
        ", security_delay=" + security_delay +
        ", late_aircraft_delay=" + late_aircraft_delay +
        '}';
  }
}
