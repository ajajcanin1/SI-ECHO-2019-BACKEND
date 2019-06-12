package com.example.echo.ga.v2.Domain;

import java.util.ArrayList;

public class Class {
	private int id;
    private Department dept;
    private Course course;
    private Professor professor;
    private MeetingTime meetingTime;
    private Room room;
    private StudentsGroup studentsGroup;
    public Class(int id, Department dept, Course course ){
        this.id = id;
        this.course = course;
        this.dept = dept;
    }
    public void setProfessor(Professor professor) { this.professor = professor; }
	public void setMeetingTime(MeetingTime meetingTime) { this.meetingTime = meetingTime; }
    public void setRoom(Room room){ this.room = room; }
    public void setStudentsGroup(StudentsGroup studentsGroup) {
        this.studentsGroup = studentsGroup;
    }
    public int getId() { return id; }
    public Department getDept() { return dept; }
    public Course getCourse() { return course; }
    public Professor getProfessor() { return professor; }
    public MeetingTime getMeetingTime() { return meetingTime; }
    public Room getRoom() { return room; }
    public StudentsGroup getStudentsGroup() {
        return studentsGroup;
    }

    public String toString() {
    	return "["+dept.getName()+","+course.getNumber()+","+room.getName()+","+ professor.getId()+","+meetingTime.getId() +"]";
    }
}
