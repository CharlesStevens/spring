package com.swastik.spring_jpa2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swastik.spring_jpa2.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}