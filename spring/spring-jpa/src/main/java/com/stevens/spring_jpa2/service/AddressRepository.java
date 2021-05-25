package com.stevens.spring_jpa2.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stevens.spring_jpa2.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
