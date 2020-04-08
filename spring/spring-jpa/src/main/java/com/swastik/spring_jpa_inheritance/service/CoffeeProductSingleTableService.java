package com.swastik.spring_jpa_inheritance.service;

import com.swastik.spring_jpa_inheritance.model.CoffeeProductSingleTable;
import com.swastik.spring_jpa_inheritance.repo.CoffeeProductSingleTableRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeProductSingleTableService {

  @Autowired
  CoffeeProductSingleTableRepo coffeeRepo;

  @Transactional
  public void save(CoffeeProductSingleTable c) {
    coffeeRepo.save(c);
  }

  public List<CoffeeProductSingleTable> getCoffeeProduct() {
    return coffeeRepo.findAll();
  }


}
