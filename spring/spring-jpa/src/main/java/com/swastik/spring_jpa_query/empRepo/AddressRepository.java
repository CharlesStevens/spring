package com.swastik.spring_jpa_query.empRepo;

import com.swastik.spring_jpa_query.empModel.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

  public List<Address> findByResidingPersonName(String name);

}
