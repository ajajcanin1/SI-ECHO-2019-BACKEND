package com.example.echo.ga.v2;

import com.example.echo.ga.v2.Domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
	private ArrayList<Room> rooms;
	private ArrayList<Professor> professors;
	private ArrayList<Course> courses;
	private ArrayList<Department> depts;
	private ArrayList<MeetingTime> meetingTimes;
	private  ArrayList<StudentsGroup> studentsGroups;
	private int numberOfClasses = 0;
	public Data() { initialize(); }
	private Data initialize() {

		//uzimati iz baze - Kabineti
		Room room1 = new Room("MA",500);
		Room room2 = new Room("VA",1);
		Room room3 = new Room("S0",1);

		rooms = new ArrayList<Room>(Arrays.asList(room1, room2, room3));

		//uzimati iz baze - ZeljeniTermini
		MeetingTime meetingTime1 = new MeetingTime(1, "PON 09:00 - 10:00", 1);
		MeetingTime meetingTime2 = new MeetingTime(2, "PON 10:00 - 11:00",2);
		MeetingTime meetingTime3 = new MeetingTime(3, "UTO 11:00 - 12:00",3);
		MeetingTime meetingTime4 = new MeetingTime(5, "CET 12:00 - 15:00",4);
		MeetingTime meetingTime5 = new MeetingTime(6, "PET 13:00 - 14:00",5);
		MeetingTime meetingTime6 = new MeetingTime(7, "SRI 15:00 - 16:00",6);
		MeetingTime meetingTime7 = new MeetingTime(8, "UTO 17:00 - 18:00",7);
		MeetingTime meetingTime8 = new MeetingTime(9, "CET 19:00 - 20:00",8);
		MeetingTime meetingTime9 = new MeetingTime(10, "CET 10:00 - 11:00",9);
		MeetingTime meetingTime10 = new MeetingTime(11, "CET 12:00 - 15:00",9);

		meetingTimes= new ArrayList<MeetingTime>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4, meetingTime5, meetingTime6, meetingTime7, meetingTime8, meetingTime9, meetingTime10));

		//uzimati iz baze - Profesori
		Professor professor1 = new Professor(1, "Novica Nosovic");
		Professor professor2 = new Professor(2, "Zeljko Juric");
		Professor professor3 = new Professor(3, "Samir Ribic");
		Professor professor4 = new Professor(4, "Dzenana Djonko");
		Professor professor5 = new Professor(5, "Sasa Mrdovic");
		Professor professor6 = new Professor(6, "Vedran Ljubovic");
		Professor professor7 = new Professor(7, "Huse Fatkic");
		Professor professor8 = new Professor(8, "Hasnija Samic");
		Professor professor9 = new Professor(9, "Senad Huseinbegovic");

		professors = new ArrayList<Professor>(Arrays.asList(professor1, professor2, professor3, professor4, professor5, professor6, professor7, professor8, professor9));

		//uzimati iz baze - Predmeti
		Course course1 = new Course("SI", "Softver inzenjering", new ArrayList<Professor>(Arrays.asList(professor1)), 150);
		/*Course course2 = new Course("DM", "Diskretna matematika", new ArrayList<Professor>(Arrays.asList(professor2)), 250);
		Course course3 = new Course("RA", "Racunarske arhitekture", new ArrayList<Professor>(Arrays.asList(professor1)), 250);
		Course course4 = new Course("ARM", "Administracija racunarskih mreza", new ArrayList<Professor>(Arrays.asList(professor5)), 60);
		Course course5 = new Course("VVS", "Verifikacija i validacija softvera", new ArrayList<Professor>(Arrays.asList(professor4)), 65);
		Course course6 = new Course("TP", "Tehnike programiranja", new ArrayList<Professor>(Arrays.asList(professor2)), 300);
		Course course7 = new Course("OR", "Osnove racunarstva", new ArrayList<Professor>(Arrays.asList(professor6)), 270);
		Course course8 = new Course("IM1", "Inzenjerska matematika 1", new ArrayList<Professor>(Arrays.asList(professor7)), 270);
		Course course9 = new Course("IF2", "Inzenjerska fizika 2", new ArrayList<Professor>(Arrays.asList(professor8)), 270);
		Course course10 = new Course("EES", "Elektronički elementi i sklopovi", new ArrayList<Professor>(Arrays.asList(professor9)), 270);*/


		courses = new ArrayList<Course>(Arrays.asList(course1));//, course2, course3, course4, course5, course6, course7, course8, course9, course10));


		StudentsGroup group1 = new StudentsGroup(1, "G1", 25, new ArrayList<Course>(Arrays.asList(course1)));
		studentsGroups = new ArrayList<StudentsGroup>(Arrays.asList(group1));

		//Odsjeci
		Department dept1 = new Department("RI", new ArrayList<Course>(Arrays.asList(course1)));//, course2,course3)));
		/*Department dept2 = new Department("EE", new ArrayList<Course>(Arrays.asList(course6, course7, course8)));
		Department dept3 = new Department("AIE", new ArrayList<Course>(Arrays.asList(course6, course9, course10)));
		Department dept4 = new Department("TK", new ArrayList<Course>(Arrays.asList( course9, course10)));*/
		depts = new ArrayList<Department>(Arrays.asList(dept1));//, dept2, dept3,dept4));
		depts.forEach(x -> numberOfClasses += x.getCourses().size());
		return this;
	}
	public ArrayList<Room> getRooms() { return rooms; }
	public ArrayList<Professor> getProfessors() { return professors; }
	public ArrayList<Course> getCourses() { return courses; }
	public ArrayList<Department> getDepts() { return depts; }
	public ArrayList<MeetingTime> getMeetingTimes() { return meetingTimes; }
	public ArrayList<StudentsGroup> getStudentsGroups() { return studentsGroups; }
	public int getNumberOfClasses() { return this.numberOfClasses; }
}
