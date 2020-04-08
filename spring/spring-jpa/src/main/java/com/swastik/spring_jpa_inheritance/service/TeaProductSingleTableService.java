package com.swastik.spring_jpa_inheritance.service;

import com.swastik.spring_jpa_inheritance.model.TeaProductSingleTable;
import com.swastik.spring_jpa_inheritance.repo.TeaProductSingleTableRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaProductSingleTableService {

  @Autowired
  TeaProductSingleTableRepo teaRepo;

  public void save(TeaProductSingleTable p) {
    teaRepo.save(p);
  }

  public List<TeaProductSingleTable> getProducts() {
    return teaRepo.findAll();
  }
}
