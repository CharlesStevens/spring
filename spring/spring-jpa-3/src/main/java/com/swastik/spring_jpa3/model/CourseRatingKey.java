package com.swastik.spring_jpa3.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseRatingKey implements Serializable {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    Long studentId;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    Long courseId;

    public CourseRatingKey() {
    }

    public CourseRatingKey(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long student_id) {
        this.studentId = student_id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long course_id) {
        this.courseId = course_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseRatingKey)) return false;
        CourseRatingKey that = (CourseRatingKey) o;
        return getStudentId().equals(that.getStudentId()) &&
                getCourseId().equals(that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getCourseId());
    }
}
