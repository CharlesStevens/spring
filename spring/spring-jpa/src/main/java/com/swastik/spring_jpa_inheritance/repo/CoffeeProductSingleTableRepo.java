package com.swastik.spring_jpa_inheritance.repo;

import com.swastik.spring_jpa_inheritance.model.CoffeeProductSingleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeProductSingleTableRepo extends
    JpaRepository<CoffeeProductSingleTable, Long> {

}
