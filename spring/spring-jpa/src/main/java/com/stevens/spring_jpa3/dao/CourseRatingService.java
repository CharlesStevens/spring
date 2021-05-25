package com.stevens.spring_jpa3.dao;

import com.stevens.spring_jpa3.model.CourseRating;
import com.stevens.spring_jpa3.service.CourseRatingRepository;
import com.stevens.spring_jpa3.service.CourseRepository;
import com.stevens.spring_jpa3.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRatingService {

    @Autowired
    CourseRatingRepository courseRepo;

    @Autowired
    CourseRepository crRepository;

    @Autowired
    StudentRepository stRepo;

    public void save(CourseRating cr) {
//        stRepo.save(cr.getStudent());
//        crRepository.save(cr.getCourse());
        courseRepo.save(cr);
    }

    public List<CourseRating> getCourseRating() {
        return courseRepo.findAll();
    }
}
