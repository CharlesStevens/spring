package com.stevens.spring_jpa3.main;

import com.stevens.spring_jpa3.config.JpaPersistance;
import com.stevens.spring_jpa3.dao.CourseRatingService;
import com.stevens.spring_jpa3.dao.StudentService;
import com.stevens.spring_jpa3.model.Course;
import com.stevens.spring_jpa3.model.CourseRating;
import com.stevens.spring_jpa3.model.Standard;
import com.stevens.spring_jpa3.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

  public static void main(String[] args) {

    try {
      Class.forName("org.hibernate.jpa.HibernatePersistenceProvider");
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
      ctx.register(JpaPersistance.class);
      ctx.refresh();

      StudentService stService = (StudentService) ctx.getBean("studentService");
      CourseRatingService crService = (CourseRatingService) ctx.getBean("courseRatingService");

      CourseRating cr = new CourseRating(new Student("Abhishek", Standard.TWELVETH),
          new Course("JAVA", 12, "LARA"), 4.03d);
//      Student student = new Student("Abhishek", Standard.TWELVETH);
//      student.addCourse(new Course("JAVA", 12, "LARA"), 4.09d);
//
//      stService.save(student);
      crService.save(cr);
      ctx.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
