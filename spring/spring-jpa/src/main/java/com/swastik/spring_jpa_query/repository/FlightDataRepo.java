package com.swastik.spring_jpa_query.repository;

import com.swastik.spring_jpa_query.model.FlightData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDataRepo extends JpaRepository<FlightData, Long> {

  public List<FlightData> fetchOnAirport(@Param("airport") String airport);

}
