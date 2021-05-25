package com.stevens.spring_jpa3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table
public class CourseRating {

  @EmbeddedId
  CourseRatingKey id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @MapsId("studentId")
  Student student;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @MapsId("courseId")
  Course course;

  @Column(precision = 5, scale = 2)
  Double rating;

  public CourseRating() {
    id = new CourseRatingKey();
  }

  public CourseRating(Student student, Course course, Double rating) {
    this.student = student;
    this.course = course;
    this.rating = rating;
    id = new CourseRatingKey(this.student.getId(), this.course.getId());

//    this.student.getCourseRatings().add(this);
//    this.course.getCourseRatings().add(this);
  }

  public CourseRating(Course course, Double rating) {
    this.course = course;
    this.course.addCourseRating(this);
    this.rating = rating;

    id = new CourseRatingKey();
  }

  public CourseRatingKey getId() {
    return id;
  }

  public void setId(CourseRatingKey id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    if (this.student == null) {
      this.student = student;
    }
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    if (this.course == null) {
      this.course = course;
    }
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }
}
