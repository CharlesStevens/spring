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

  public List<FlightData> getNamedQueryResult(String airport) {
    return flightDataRepo.fetchOnAirport(airport);
  }

  public void saveFlightData(FlightData flightData) {
    flightDataRepo.save(flightData);
  }

  public List<FlightData> getAllFlightData() {
    return flightDataRepo
        .findAll(Sort.by(Order.asc("airport"), Order.desc("carrier")));
//    return flightDataRepo.findAll();
  }

  public Page<FlightData> getAllPageFlightData(Pageable pageable) {
    return flightDataRepo.findAll(pageable);
  }
}
