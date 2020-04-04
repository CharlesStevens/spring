package com.swastik.spring_jpa3.service;

import com.swastik.spring_jpa3.model.CourseRating;
import com.swastik.spring_jpa3.model.CourseRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRatingRepository extends JpaRepository<CourseRating, CourseRatingKey> {
}
