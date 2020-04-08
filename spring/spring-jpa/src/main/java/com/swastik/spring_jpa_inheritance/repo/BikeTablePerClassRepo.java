package com.swastik.spring_jpa_inheritance.repo;

import com.swastik.spring_jpa_inheritance.model.BikeTablePerClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeTablePerClassRepo extends JpaRepository<BikeTablePerClass, Long> {

}
