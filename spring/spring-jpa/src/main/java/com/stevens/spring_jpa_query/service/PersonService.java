package com.stevens.spring_jpa_query.service;

import com.stevens.spring_jpa_query.empModel.Address;
import com.stevens.spring_jpa_query.empModel.Person;
import com.stevens.spring_jpa_query.empRepo.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  AddressService addressService;

  public Address saveAndGetAddress(Person person) {
    personRepository.save(person);
    System.out.println("###### Saved Person with name : " + person.getName());
    List<Address> address = addressService.findByResidingPersonName(person.getName());

    return address.get(0);
  }
}
