package com.swastik.spring_jpa_query.repository;

import com.swastik.spring_jpa_query.model.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDataRepo extends JpaRepository<FlightData, Long> {

}
