package com.stevens.spring_jpa_inheritance.service;

import com.stevens.spring_jpa_inheritance.model.BikeTablePerClass;
import com.stevens.spring_jpa_inheritance.repo.BikeTablePerClassRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeTablePerClassService {

  @Autowired
  BikeTablePerClassRepo repo;

  public void save(BikeTablePerClass c) {
    repo.save(c);
  }

  public List<BikeTablePerClass> getVehicles() {
    return repo.findAll();
  }
}
