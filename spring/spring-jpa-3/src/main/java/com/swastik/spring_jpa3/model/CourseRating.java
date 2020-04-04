package com.swastik.spring_jpa3.model;

import javax.persistence.*;

@Entity
@Table
public class CourseRating {

    @EmbeddedId
    CourseRatingKey id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    Course course;

    @Column(precision = 5, scale = 2)
    Double rating;

    public CourseRating() {
        id = new CourseRatingKey();
    }

    public CourseRating(Student student, Course course, Double rating) {
        this.student = student;
        this.student.addCourseRating(this);
        this.course = course;
        this.course.addCourseRating(this);
        this.rating = rating;
        id = new CourseRatingKey();

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
        if (this.student == null)
            this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (this.course == null)
            this.course = course;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
