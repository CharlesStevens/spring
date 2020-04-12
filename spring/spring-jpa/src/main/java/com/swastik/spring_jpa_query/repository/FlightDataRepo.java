package com.swastik.spring_jpa_query.repository;

import com.swastik.spring_jpa_query.model.FlightData;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDataRepo extends JpaRepository<FlightData, Long> {

  //  @Query(value = "select f from FlightData f where carrier = :carrier")
////  @Query(value = "select * from FlightData where carrier = :carrier", nativeQuery = true) // Cannot use Sort for native query throws Exception
  public List<FlightData> fetchOnAirport(@Param("carrier") String carrier);


  @Query(value = "select f from FlightData f where carrier = :carrier")
  public Page<FlightData> fetchOnAirportPageableJPQL(@Param("carrier") String carrier,
      Pageable pageable);

  @Query(value = "select * from FlightData where carrier = :carrier", nativeQuery = true)
  public Page<FlightData> fetchOnAirportPageableNative(@Param("carrier") String carrier,
      Pageable pageable);

  @Modifying
  @Query(value = "update flightdata set airport = :airport where airport = :airport1", nativeQuery = true)
  public int updateNativeQuery(@Param("airport") String airport,
      @Param("airport1") String airport1);

  public List<FlightData> findByCarrierStartingWithOrderByAirport(String carrier);

  public List<FlightData> findByMonthLessThanOrderByYear(int i);

  @Procedure
  public int getFlightCountByCarrier(String carrier);

  //  @Procedure
  @Query(nativeQuery = true, value = "call getAllRecordLimit10()")
  public List<FlightData> getAllRecordLimit10();

  @Transactional
  @Procedure(name = "FlightData.procedureWithArgs", outputParameterName = "cnt")
  public Integer procedureWithArgs(@Param("crr") String crr);


  @Query(nativeQuery = true, value = "select * from FlightData f full join spring_jpa_new.employee e on f.carrier = e.carrier limit 10")
  public List<FlightData> getFromFlightDataOnMatchingWithEmployee();

}
