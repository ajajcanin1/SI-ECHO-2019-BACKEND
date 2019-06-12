package com.example.echo.ga.v2.Domain;
import java.util.ArrayList;

public class Course {
	 private String number = null;
	 private String name = null;
	 private int maxNumbOfStudents;
	 private ArrayList<Professor> professors;
	 public Course(String number, String name, ArrayList<Professor> professors, int maxNumbOfStudents){
		 this.number = number;
	     this.name = name;
	     this.professors = professors;
	     this.maxNumbOfStudents = maxNumbOfStudents;
	 }
	 public String getNumber() { return number; }
	 public String getName() { return name; }
	 public ArrayList<Professor> getProfessors() { return professors; }
	 public int getMaxNumbOfStudents() { return maxNumbOfStudents; }
	 public String toString() { return name; }
}
