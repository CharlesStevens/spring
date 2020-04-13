package com.swastik.spring_jpa_query.empRepo;

import com.swastik.spring_jpa_query.empModel.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  public List<Person> findByName(String name);

}
