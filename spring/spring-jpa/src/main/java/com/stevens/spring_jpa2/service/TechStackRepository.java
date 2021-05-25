package com.stevens.spring_jpa2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stevens.spring_jpa2.model.TechStack;

@Repository
public interface TechStackRepository extends JpaRepository<TechStack, Long> {

}
