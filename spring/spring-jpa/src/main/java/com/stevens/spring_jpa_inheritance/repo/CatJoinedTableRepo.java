package com.stevens.spring_jpa_inheritance.repo;

import com.stevens.spring_jpa_inheritance.model.CatJoinedTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatJoinedTableRepo extends JpaRepository<CatJoinedTable, Long> {

}
