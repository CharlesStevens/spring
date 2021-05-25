package com.stevens.spring_jpa3.dao;

import com.stevens.spring_jpa3.model.Student;
import com.stevens.spring_jpa3.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;


    public void save(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getCourseRating() {
        return studentRepo.findAll();
    }
}