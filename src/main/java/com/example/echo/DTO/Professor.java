package com.example.echo.DTO;
import java.util.List;
import java.util.Objects;

public class Professor {

    private int id;
    private String name;
    private List<CourseClass> courseClasses;

    public Professor(int id, String name, List<CourseClass> courseClasses) {
        this.id = id;
        this.name = name;
        this.courseClasses = courseClasses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseClass> getCourseClasses() {
        return courseClasses;
    }

    public void setCourseClasses(List<CourseClass> courseClasses) {
        this.courseClasses = courseClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return id == professor.id &&
                Objects.equals(name, professor.name) &&
                Objects.equals(courseClasses, professor.courseClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, courseClasses);
    }

    public void addCourseClass(CourseClass c) {
        courseClasses.add(c);
    }
}
