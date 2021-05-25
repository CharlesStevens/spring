package com.stevens.spring_jpa1.dao;

import com.stevens.spring_jpa1.model.Address;
import com.stevens.spring_jpa1.service.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  AddressRepository addRepository;

  public void saveAddress(Address address) {
    addRepository.save(address);
  }

  public Iterable<Address> listAddress() {
    return addRepository.findAll();
  }
}
