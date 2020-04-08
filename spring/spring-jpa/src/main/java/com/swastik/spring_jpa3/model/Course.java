package com.swastik.spring_jpa3.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Course implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column
  String courseName;

  @Column
  Integer courseDuration;

  @Column
  String courseFaculty;

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  Set<CourseRating> courseRatings = new HashSet<>();

  public Course() {
  }

  public Course(String courseName, Integer courseDuration, String courseFaculty) {
    this.courseName = courseName;
    this.courseDuration = courseDuration;
    this.courseFaculty = courseFaculty;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Integer getCourseDuration() {
    return courseDuration;
  }

  public void setCourseDuration(Integer courseDuration) {
    this.courseDuration = courseDuration;
  }

  public String getCourseFaculty() {
    return courseFaculty;
  }

  public void setCourseFaculty(String courseFaculty) {
    this.courseFaculty = courseFaculty;
  }

  public Set<CourseRating> getCourseRatings() {
    return courseRatings;
  }

  public void setCourseRatings(Set<CourseRating> courseRating) {
    this.courseRatings = courseRating;
  }

  public void addCourseRating(CourseRating cr) {
    if (!this.courseRatings.contains(cr)) {
      this.courseRatings.add(cr);
      cr.setCourse(this);
    }
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (!(o instanceof Course)) {
          return false;
      }
    Course course = (Course) o;
    return Objects.equals(getId(), course.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
