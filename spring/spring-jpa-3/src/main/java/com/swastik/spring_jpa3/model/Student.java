package com.swastik.spring_jpa3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String studentName;

    @Column
    @Enumerated(EnumType.STRING)
    Standard standard;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<CourseRating> courseRatings = new HashSet<>();

    public Student() {
    }

    public Student(String studentName, Standard standard) {
        this.studentName = studentName;
        this.standard = standard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Set<CourseRating> getCourseRatings() {
        return courseRatings;
    }

    public void setCourseRatings(Set<CourseRating> courseRatings) {
        this.courseRatings = courseRatings;
    }

    public void addCourseRating(CourseRating cr) {
        if (!this.courseRatings.contains(cr)) {
            this.courseRatings.add(cr);
            cr.setStudent(this);
        }
    }
}
