package com.swastik.spring_jpa.dao;

import com.swastik.spring_jpa.model.Address;
import com.swastik.spring_jpa.service.AddressRepository;
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
