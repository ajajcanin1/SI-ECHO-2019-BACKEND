package com.example.echo.ga.v2;

import com.example.echo.ga.v2.Domain.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
	private ArrayList<Room> rooms;
	private ArrayList<Professor> winterProfessors;
	private ArrayList<Professor> summerProfessors;
	private ArrayList<Course> winterCourses;
	private ArrayList<Course> summerCourses;
	private ArrayList<Department> depts;
	private ArrayList<MeetingTime> summerMeetingTimes;
	private ArrayList<MeetingTime> winterMeetingTimes;
	private  ArrayList<StudentsGroup> studentsGroups;
	private int numberOfClasses = 0;
	public Data() { initialize(); }
	private Data initialize() {

		//uzimati iz baze - Kabineti
		Room room1 = new Room("VA",300, false);
		Room room2 = new Room("MA",200, false);
		Room room3 = new Room("S0",150, false);
		Room room4 = new Room("EE1",80, false);
		Room room5 = new Room("EE2",80, false);
		Room room6 = new Room("0-01",100, false);
		Room room7 = new Room("0-02",100, false);
		Room room8 = new Room("0-03",100, false);
		Room room9 = new Room("0-13",80, false);
		Room room10 = new Room("0-15",30, true);
		Room room11 = new Room("1-01",80, false);
		Room room12 = new Room("1-02",30, true);
		Room room13 = new Room("1-03",80, false);
		Room room14 = new Room("1-04",30, true);
		Room room15 = new Room("1-07",30, true);
		Room room16 = new Room("1-11",30, true);
		Room room17 = new Room("1-13",30, true);
		Room room18 = new Room("1-15",30, true);
		Room room19 = new Room("1-20",30, true);
		Room room20 = new Room("1-22",30, true);
		Room room21 = new Room("2-01",80, false);
		Room room22 = new Room("2-02",80, false);
		Room room23 = new Room("2-03",80, false);
		Room room24 = new Room("2-06",80, false);
		Room room25 = new Room("2-11",30, true);
		Room room26 = new Room("2-13",30, true);
		Room room27 = new Room("2-15",30, true);
		Room room28 = new Room("2-20",30, true);
		Room room29 = new Room("2-22",30, true);
		Room room30 = new Room("2-26",30, true);
		Room room31 = new Room("3-02",80, false);

		rooms = new ArrayList<Room>(Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10,
				room11, room12, room13, room14, room15, room16, room17, room18, room19, room20, room21, room22, room23, room24,
				room25, room26, room27, room28, room29, room30, room31));

		//uzimati iz baze - Profesori
		//ZIMSKI
		//6. semestar ri
		//profesori
		Professor professor1 = new Professor(1, "Dženana Đonko", false);
		Professor professor2 = new Professor(2, "Anel Tanović", false);
		Professor professor3 = new Professor(3, "Kemal Hajdarević", false);
		Professor professor4 = new Professor(4, "Selma Rizvić", false);
		Professor professor5 = new Professor(5, "Vensada Okanović", false);
		Professor professor6 = new Professor(6, "Razija Turčinhodžić", false);

		//asistenti
		Professor professor7 = new Professor(7, "Kerim Hodžić", true);
		Professor professor8 = new Professor(8, "Aida Granulo", true);
		Professor professor9 = new Professor(9, "Zoran Cico", true);
		Professor professor10 = new Professor(10, "Ivona Ivković", true);
		Professor professor11 = new Professor(11, "Irfan Prazina", true);
		Professor professor13 = new Professor(13, "Hana Haseljić", true);

		//LJETNI
		//profesori
		Professor professor23 = new Professor(23, "Almir Karabegović", false);
		Professor professor24 = new Professor(24, "Zikrija Avdagić", false);
		Professor professor26 = new Professor(26, "Saša Mrdović", false);

		//asistenti
		Professor professor12 = new Professor(12, "Novica Nosović", false);
		Professor professor28 = new Professor(28, "Marina Milićević", true);
		Professor professor29 = new Professor(29, "Almir Djedović", true);
		Professor professor30 = new Professor(30, "Vedad Letić", true);
		Professor professor31 = new Professor(31, "Haris Šemić", true);
		Professor professor32 = new Professor(32, "Kenan Halilović", true);

		winterProfessors = new ArrayList<Professor>(Arrays.asList(professor1,professor2,professor3,professor4,professor5,professor6,
				professor7,professor8,professor9,professor10,professor11,professor13));
		summerProfessors = new ArrayList<Professor>(Arrays.asList(professor12, professor23, professor24,
				professor26, professor28, professor29, professor30, professor31, professor32));

		//uzimati iz baze - ZeljeniTermini
		//RI-zimski semestar zeljeni termini

		//Profesori
		MeetingTime meetingTime33 = new MeetingTime(33, "PON","09:00 - 12:00", 1);
		MeetingTime meetingTime34= new MeetingTime(34, "UTO","09:00 - 12:00", 1);
		MeetingTime meetingTime35 = new MeetingTime(35, "SRI","09:00 - 12:00", 1);
		MeetingTime meetingTime36 = new MeetingTime(36, "PET","13:00 - 16:00", 1);

		MeetingTime meetingTime37 = new MeetingTime(37, "PON","12:00 - 15:00", 2);
		MeetingTime meetingTime38= new MeetingTime(38, "CET","15:00 - 18:00", 2);
		MeetingTime meetingTime39 = new MeetingTime(39, "SRI","12:00 - 15:00", 2);
		MeetingTime meetingTime40 = new MeetingTime(40, "PET","13:00 - 16:00", 2);

		MeetingTime meetingTime41 = new MeetingTime(41, "PET","16:00 - 19:00", 3);
		MeetingTime meetingTime42= new MeetingTime(42, "SRI","09:00 - 12:00", 3);
		MeetingTime meetingTime43 = new MeetingTime(43, "UTO","12:00 - 15:00", 3);
		MeetingTime meetingTime44 = new MeetingTime(44, "PON","15:00 - 18:00", 3);

		MeetingTime meetingTime45 = new MeetingTime(45, "SRI","15:00 - 18:00", 4);
		MeetingTime meetingTime46= new MeetingTime(46, "UTO","16:00 - 19:00", 4);
		MeetingTime meetingTime47 = new MeetingTime(47, "CET","14:00 - 17:00", 4);
		MeetingTime meetingTime48 = new MeetingTime(48, "PET","09:00 - 12:00", 4);

		MeetingTime meetingTime49 = new MeetingTime(49, "UTO","12:00 - 15:00", 5);
		MeetingTime meetingTime50= new MeetingTime(50, "SRI","12:00 - 15:00", 5);
		MeetingTime meetingTime51 = new MeetingTime(51, "CET","11:00 - 14:00", 5);
		MeetingTime meetingTime52 = new MeetingTime(52, "PET","13:00 - 16:00", 5);

		MeetingTime meetingTime53 = new MeetingTime(53, "SRI","09:00 - 12:00", 6);
		MeetingTime meetingTime54= new MeetingTime(54, "UTO","11:00 - 14:00", 6);
		MeetingTime meetingTime55 = new MeetingTime(55, "PON","12:00 - 15:00", 6);
		MeetingTime meetingTime56 = new MeetingTime(56, "PET","09:00 - 12:00", 6);



		return this;
	}
	public ArrayList<Room> getRooms() { return rooms; }
	public ArrayList<Professor> getProfessors() { return winterProfessors; }
	public ArrayList<Course> getCourses() { return winterCourses; }
	public ArrayList<Department> getDepts() { return depts; }
	public ArrayList<MeetingTime> getMeetingTimes() { return winterMeetingTimes; }
	public ArrayList<StudentsGroup> getStudentsGroups() { return studentsGroups; }
	public int getNumberOfClasses() { return this.numberOfClasses; }
}