package com.swastik.spring_jpa_query.service;

import com.swastik.spring_jpa_query.empModel.Address;
import com.swastik.spring_jpa_query.empModel.Person;
import com.swastik.spring_jpa_query.empRepo.AddressRepository;
import com.swastik.spring_jpa_query.empRepo.PersonRepository;
import java.util.List;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  AddressRepository addressRepository;

  @Autowired
  PersonRepository personRepository;

  @Transactional(value = TxType.NEVER)
  public List<Address> findByResidingPersonName(String name) {
    List<Person> ps = personRepository.findByName(name);

    System.out.println("###### Fetched person from PersonRepo size : " + ps.size());
    if (ps != null && !ps.isEmpty()) {
      return addressRepository.findByResidingPersonName(name);
    }
    return null;
  }

  public void saveAddress(Address address) {
    addressRepository.save(address);
  }

}
