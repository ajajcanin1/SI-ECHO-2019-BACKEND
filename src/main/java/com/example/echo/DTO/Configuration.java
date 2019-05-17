package com.example.echo.DTO;
import java.util.ArrayList;
import java.util.List;

public class Configuration {

    public Configuration() {
    }

    public int GetNumberOfRooms() {
        return 4;
    }
    public int GetNumberOfCourseClasses() {
        return 20;
    }
    public List<CourseClass> GetCourseClasses() {
        List<CourseClass> c = new ArrayList<CourseClass>();
        return c;
    }
}
