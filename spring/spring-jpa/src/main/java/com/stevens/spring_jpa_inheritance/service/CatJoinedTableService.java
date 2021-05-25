package com.stevens.spring_jpa_inheritance.service;

import com.stevens.spring_jpa_inheritance.model.CatJoinedTable;
import com.stevens.spring_jpa_inheritance.repo.CatJoinedTableRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatJoinedTableService {

  @Autowired
  CatJoinedTableRepo repo;

  public void save(CatJoinedTable t) {
    repo.save(t);
  }

  public List<CatJoinedTable> getAnimals() {
    return repo.findAll();
  }
}
