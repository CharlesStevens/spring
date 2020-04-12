package com.swastik.spring_jpa_query.service;

import com.swastik.spring_jpa_query.model.FlightData;
import com.swastik.spring_jpa_query.repository.FlightDataRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service
public class FlightDataService {

  @Autowired
  FlightDataRepo flightDataRepo;

  public void saveAllFlightData(List<FlightData> flightDataCollection) {
    flightDataRepo.saveAll(flightDataCollection);
  }

  public List<FlightData> getNamedQueryResult(String carrier, Sort sort) {
    return flightDataRepo.fetchOnAirport(carrier);
  }

  public Page<FlightData> getNamedQueryResultJpql(String carrier, Pageable pageable) {
    return flightDataRepo.fetchOnAirportPageableJPQL(carrier, pageable);
  }

  public Page<FlightData> getNamedQueryResultNative(String carrier, Pageable pageable) {
    return flightDataRepo.fetchOnAirportPageableNative(carrier, pageable);
  }

  public void saveFlightData(FlightData flightData) {
    flightDataRepo.save(flightData);
  }

  public List<FlightData> getAllFlightData() {
    return flightDataRepo
        .findAll(Sort.by(Order.asc("airport"), Order.desc("carrier")));
//    return flightDataRepo.findAll();
  }

  public int updateFlightData(String airport, String airport1) {
    return flightDataRepo
        .updateNativeQuery(airport, airport1);
  }

  public Page<FlightData> getAllPageFlightData(Pageable pageable) {
    return flightDataRepo.findAll(pageable);
  }

  public List<FlightData> findByCarrierStartingWithOrderByAirport(String carrier) {
    return flightDataRepo.findByCarrierStartingWithOrderByAirport(carrier);
  }

  public List<FlightData> findByMonthLessThan(int i) {
    return flightDataRepo.findByMonthLessThanOrderByYear(i);
  }

  public int getFlightCountByCarrier(String carrier) {
    return flightDataRepo.getFlightCountByCarrier(carrier);
  }

  public List<FlightData> getAllRecordLimit10() {
    return flightDataRepo.getAllRecordLimit10();
  }

  public int procedureWithArgs(String crr) {
    return flightDataRepo.procedureWithArgs(crr);
  }

  public List<FlightData> getFromFlightDataOnMatchingWithEmployee() {
    return flightDataRepo.getFromFlightDataOnMatchingWithEmployee();
  }
}
