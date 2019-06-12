package com.example.echo.ga.v2.Domain;

import java.util.ArrayList;

public class StudentsGroup {
    private int id;
    private String name;
    private int numberOfStudents;
    private ArrayList<Course> courses;

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setNumberOfStudents(int numberOfStudents) { this.numberOfStudents = numberOfStudents; }
    public void setCourses(ArrayList<Course> courses) { this.courses = courses; }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getNumberOfStudents() { return numberOfStudents; }
    public ArrayList<Course> getCourses() { return courses; }

    public StudentsGroup(int id, String name, int numberOfStudents, ArrayList<Course> courses) {
        this.id = id;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.courses = courses;
    }
}
