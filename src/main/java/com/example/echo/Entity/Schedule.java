package com.example.echo.Entity;
import java.util.HashMap;
import java.util.Vector;
import java.util.List;

public class Schedule {
    private int numberOfCrossoverPoints;
    private int mutationSize;
    private int crossoverProbability;
    private int mutationProbability;
    private float fitness;
    private Vector<Boolean> criteria;
    private Vector<List<CourseClass>> slots;
    private HashMap<CourseClass, Integer> classes;


}
