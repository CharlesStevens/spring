package com.swastik.spring_jpa1.service;

import com.swastik.spring_jpa1.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
