package com.example.echo.Entity;
import java.util.List;
import java.util.Objects;

public class StudentsGroup {
    private int id;
    private String name;
    private int numberOfStudents;
    private List<CourseClass> courseClasses;

    public StudentsGroup(int id, String name, int numberOfStudents, List<CourseClass> courseClasses) {
        this.id = id;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
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


    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    //Dodati
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
        StudentsGroup that = (StudentsGroup) o;
        return id == that.id &&
                numberOfStudents == that.numberOfStudents &&
                Objects.equals(name, that.name) &&
                Objects.equals(courseClasses, that.courseClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfStudents, courseClasses);
    }

    public void addClass(CourseClass c) {
        courseClasses.add(c);
    }
}
