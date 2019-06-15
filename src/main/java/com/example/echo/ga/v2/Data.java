package com.example.echo.ga.v2;

import com.example.echo.ga.v2.Domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Data {
	private ArrayList<Room> rooms;
	private String semestar;
	private String godina;
	private ArrayList<Professor> winterProfessors;
	private ArrayList<Professor> summerProfessors;
	private ArrayList<Course> winterCourses;
	private ArrayList<Course> summerCourses;
	private ArrayList<Department> depts;
	private ArrayList<MeetingTime> summerMeetingTimes;
	private ArrayList<MeetingTime> winterMeetingTimes;
	private  ArrayList<StudentsGroup> winterStudentsGroups;
	private  ArrayList<StudentsGroup> summerStudentsGroups;
	private int numberOfClasses = 0;
	public Data() { initialize(); }
	public ArrayList<Professor> pozoviZaProfesore() throws Exception {
		String url = "http://localhost:31905/si2019/echo/profesori/3";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		System.out.println("Salje se zahtjev na link" + url);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputline;
		StringBuffer response = new StringBuffer();
		while ((inputline = in.readLine()) != null) {
			response.append(inputline);
		}
		in.close();
		System.out.println(response.toString());
		JSONArray niz=new JSONArray(response.toString());	
		ArrayList<Professor> listaProfesora=new ArrayList<Professor>();
		for(int i=0; i<niz.length(); i++){
			Integer id=niz.getJSONObject(i).getInt("id");
			String name=niz.getJSONObject(i).getString("ime")+" "+ niz.getJSONObject(i).getString("prezime");
			Professor novi= new Professor(id, name, true);
			listaProfesora.add(novi);
		}
		System.out.println(response.length());
		System.out.println(niz.length());
		for(int i=0; i<listaProfesora.size(); i++){
			System.out.println(listaProfesora.get(i).getId());
			System.out.println(listaProfesora.get(i).getName());
		}
		return listaProfesora;
	}
	public ArrayList<MeetingTime> pozoviZaTermine() throws Exception {
		String url = "http://localhost:31905/si2019/echo/all";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		System.out.println("Salje se zahtjev na link" + url);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputline;
		StringBuffer response = new StringBuffer();
		while ((inputline = in.readLine()) != null) {
			response.append(inputline);
		}
		in.close();
		System.out.println(response.toString());
		JSONArray niz=new JSONArray(response.toString());	
		ArrayList<MeetingTime> listaTerminaa=new ArrayList<MeetingTime>();
		for(int i=0; i<niz.length(); i++){
			Integer id=niz.getJSONObject(i).getInt("idZeljeniTermin");
			String day= niz.getJSONObject(i).getString("danUSedmici");
			String time=niz.getJSONObject(i).getString("vrijeme");
			Integer idProf=0;
			try{
				idProf=niz.getJSONObject(i).getInt("idPredavac");
			}catch(Exception e){
				idProf=0;
			}
			MeetingTime novi= new MeetingTime(id,day, time, idProf);
			listaTerminaa.add(novi);
		}
		System.out.println(response.length());
		System.out.println(niz.length());
		return listaTerminaa;
	}
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

		//Asistenti
		MeetingTime meetingTime57 = new MeetingTime(57, "PON","09:00 - 10:00", 7);
		MeetingTime meetingTime58= new MeetingTime(58, "SRI","10:00 - 11:00", 7);
		MeetingTime meetingTime59 = new MeetingTime(59, "SRI","12:00 - 13:00", 7);
		MeetingTime meetingTime60 = new MeetingTime(60, "SRI","13:00 - 14:00", 7);

		MeetingTime meetingTime65 = new MeetingTime(65, "PON","10:00 - 11:00", 8);
		MeetingTime meetingTime66= new MeetingTime(66, "UTO","15:00 - 16:00", 8);
		MeetingTime meetingTime67 = new MeetingTime(67, "UTO","16:00 - 17:00", 8);
		MeetingTime meetingTime68 = new MeetingTime(68, "UTO","17:00 - 18:00", 8);

		MeetingTime meetingTime69 = new MeetingTime(69, "CET","09:00 - 10:00", 9);
		MeetingTime meetingTime70= new MeetingTime(70, "CET","10:00 - 11:00", 9);
		MeetingTime meetingTime71 = new MeetingTime(71, "PET","12:00 - 13:00", 9);
		MeetingTime meetingTime72 = new MeetingTime(72, "PET","13:00 - 14:00", 9);

		MeetingTime meetingTime73 = new MeetingTime(73, "CET","18:00 - 19:00", 10);
		MeetingTime meetingTime74= new MeetingTime(74, "CET","19:00 - 20:00", 10);
		MeetingTime meetingTime75 = new MeetingTime(75, "PON","18:00 - 19:00", 10);
		MeetingTime meetingTime76 = new MeetingTime(76, "PET","19:00 - 20:00", 10);

		MeetingTime meetingTime77 = new MeetingTime(77, "UTO","17:00 - 18:00", 11);
		MeetingTime meetingTime78= new MeetingTime(78, "SRI","17:00 - 18:00", 11);
		MeetingTime meetingTime79 = new MeetingTime(79, "CET","15:00 - 16:00", 11);
		MeetingTime meetingTime80 = new MeetingTime(80, "PET","08:00 - 09:00", 11);


		MeetingTime meetingTime85 = new MeetingTime(85, "PON","09:00 - 10:00", 13);
		MeetingTime meetingTime86= new MeetingTime(86, "UTO","12:00 - 13:00", 13);
		MeetingTime meetingTime87 = new MeetingTime(87, "SRI","13:00 - 14:00", 13);
		MeetingTime meetingTime88 = new MeetingTime(88, "PET","14:00 - 15:00", 13);

		winterMeetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime33,meetingTime34,meetingTime35,meetingTime36,meetingTime37,meetingTime38,meetingTime39
				,meetingTime40,meetingTime41,meetingTime42,meetingTime43,meetingTime44,meetingTime45,meetingTime46,meetingTime47,meetingTime48,meetingTime49,meetingTime50
				,meetingTime51,meetingTime52,meetingTime53,meetingTime54,meetingTime55,meetingTime56,meetingTime57,meetingTime58,meetingTime59,meetingTime60,meetingTime65
				,meetingTime66,meetingTime67,meetingTime68,meetingTime69,meetingTime70,meetingTime71,meetingTime72,meetingTime73,meetingTime74,meetingTime75,meetingTime76,meetingTime77
				,meetingTime78,meetingTime79,meetingTime80, meetingTime85, meetingTime86, meetingTime87, meetingTime88));

		//RI-ljetnjji semestar zeljeni termini
		MeetingTime meetingTime1 = new MeetingTime(1, "PON","12:00 - 15:00", 23);
		MeetingTime meetingTime2 = new MeetingTime(2, "UTO","12:00 - 15:00", 23);
		MeetingTime meetingTime3 = new MeetingTime(3, "SRI","12:00 - 15:00", 23);
		MeetingTime meetingTime4 = new MeetingTime(4, "CET","12:00 - 15:00", 23);

		MeetingTime meetingTime5 = new MeetingTime(5, "SRI","09:00 - 12:00", 24);
		MeetingTime meetingTime6 = new MeetingTime(6, "CET","09:00 - 12:00", 24);
		MeetingTime meetingTime7 = new MeetingTime(7, "CET","12:00 - 15:00", 24);
		MeetingTime meetingTime8 = new MeetingTime(8, "PET","12:00 - 15:00", 24);

		MeetingTime meetingTime9 = new MeetingTime(9, "UTO","09:00 - 12:00", 26);
		MeetingTime meetingTime10 = new MeetingTime(10, "SRI","09:00 - 12:00", 26);
		MeetingTime meetingTime11 = new MeetingTime(11, "CET","09:00 - 12:00", 26);
		MeetingTime meetingTime12 = new MeetingTime(12, "PET","09:00 - 12:00", 26);

		MeetingTime meetingTime13 = new MeetingTime(13, "PON","15:00 - 16:00", 28);
		MeetingTime meetingTime14 = new MeetingTime(14, "UTO","15:00 - 16:00", 28);
		MeetingTime meetingTime15 = new MeetingTime(15, "SRI","15:00 - 16:00", 28);
		MeetingTime meetingTime16 = new MeetingTime(16, "CET","15:00 - 16:00", 28);

		MeetingTime meetingTime17 = new MeetingTime(17, "PET","16:00 - 17:00", 29);
		MeetingTime meetingTime18 = new MeetingTime(18, "CET","16:00 - 17:00", 29);
		MeetingTime meetingTime19 = new MeetingTime(19, "SRI","08:00 - 09:00", 29);
		MeetingTime meetingTime20 = new MeetingTime(20, "SRI","08:00 - 09:00", 29);

		MeetingTime meetingTime21 = new MeetingTime(21, "PON","16:00 - 17:00", 30);
		MeetingTime meetingTime22 = new MeetingTime(22, "PON","17:00 - 18:00", 30);
		MeetingTime meetingTime23 = new MeetingTime(23, "PON","18:00 - 19:00", 30);
		MeetingTime meetingTime24 = new MeetingTime(24, "UTO","18:00 - 19:00", 30);

		MeetingTime meetingTime25 = new MeetingTime(25, "SRI","16:00 - 17:00", 31);
		MeetingTime meetingTime26 = new MeetingTime(26, "CET","17:00 - 18:00", 31);
		MeetingTime meetingTime27 = new MeetingTime(27, "PET","17:00 - 18:00", 31);
		MeetingTime meetingTime28 = new MeetingTime(28, "PET","18:00 - 19:00", 31);

		MeetingTime meetingTime29 = new MeetingTime(29, "CET","08:00 - 09:00", 32);
		MeetingTime meetingTime30 = new MeetingTime(30, "CET","15:00 - 16:00", 32);
		MeetingTime meetingTime31 = new MeetingTime(31, "PET","15:00 - 16:00", 32);
		MeetingTime meetingTime32 = new MeetingTime(32, "PET","16:00 - 17:00", 32);

		//Profesori prva godina-NN
		MeetingTime meetingTime61 = new MeetingTime(61, "PON","09:00 - 12:00", 12);
		MeetingTime meetingTime62 = new MeetingTime(62, "UTO","09:00 - 12:00", 12);
		MeetingTime meetingTime63 = new MeetingTime(63, "SRI","09:00 - 12:00", 12);
		MeetingTime meetingTime64 = new MeetingTime(64, "CET","09:00 - 12:00", 12);


		summerMeetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4, meetingTime5, meetingTime6, meetingTime7, meetingTime8,
				meetingTime9, meetingTime10, meetingTime11, meetingTime12, meetingTime13, meetingTime14, meetingTime15, meetingTime16, meetingTime17, meetingTime18,
				meetingTime19, meetingTime20, meetingTime21, meetingTime22, meetingTime23, meetingTime24, meetingTime25, meetingTime26, meetingTime27, meetingTime28,
				meetingTime29, meetingTime30, meetingTime31, meetingTime32, meetingTime61, meetingTime62, meetingTime63, meetingTime64));

				try {
					ArrayList<MeetingTime> l= pozoviZaTermine();
					} catch (Exception e) {
					e.printStackTrace();
					}
				try {
						ArrayList<Professor> listaP=pozoviZaProfesore();
				} catch (Exception e) {
						e.printStackTrace();
					}
		//uzimati iz baze - Predmeti
		//ZIMSKI
		//5. semestar ri
		Course course1 = new Course("VVS", "Verifikacija i validacija softvera", new ArrayList<Professor>(Arrays.asList(professor1, professor7)), 100);
		Course course2 = new Course("OIS", "Osnove informacionih sistema", new ArrayList<Professor>(Arrays.asList(professor2, professor8)), 100);
		Course course3 = new Course("RMS", "Računarsko modeliranje i simulacija", new ArrayList<Professor>(Arrays.asList(professor3, professor9)), 100);
		Course course4 = new Course("RG", "Računarska grafika", new ArrayList<Professor>(Arrays.asList(professor4, professor10)), 100);
		Course course5 = new Course("WT", "Web tehnologije", new ArrayList<Professor>(Arrays.asList(professor5, professor11)), 100);
		Course course6 = new Course("OOI", "Osnove operacionih istraživanja", new ArrayList<Professor>(Arrays.asList(professor6, professor13)), 100);

		//LJETNJi
		//6. semestar ri
		Course course33 = new Course("SI", "Softver inženjering", new ArrayList<Professor>(Arrays.asList(professor12, professor32)), 100);
		Course course34 = new Course("PIS", "Projektovanje informacionih sistema", new ArrayList<Professor>(Arrays.asList(professor23, professor29, professor28)), 100);
		Course course35 = new Course("VI", "Vještačka inteligencija", new ArrayList<Professor>(Arrays.asList(professor24, professor30)), 100);

		Course course37 = new Course("ARM", "Administracija računarskih mreža", new ArrayList<Professor>(Arrays.asList(professor26, professor31)), 100);

		summerCourses = new ArrayList<Course>(Arrays.asList(course33, course34, course35, course37));

		winterCourses = new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6));

		//Studentske grupe-zimski
		StudentsGroup group1 = new StudentsGroup(1, "RI3", 100, false, new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6)));
		StudentsGroup group2 = new StudentsGroup(2, "L1", 25, true, new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6)));
		StudentsGroup group3 = new StudentsGroup(3, "L2", 25, true, new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6)));
		StudentsGroup group4 = new StudentsGroup(4, "L3", 25, true, new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6)));
		StudentsGroup group5 = new StudentsGroup(5, "L4", 25, true, new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6)));


		//Studentske grupe-ljetnji
		StudentsGroup group19 = new StudentsGroup(19, "RI3", 100, false, new ArrayList<Course>(Arrays.asList(course33, course34, course35, course37)));
		StudentsGroup group20 = new StudentsGroup(20, "L1", 25, true, new ArrayList<Course>(Arrays.asList(course33, course34, course35, course37)));
		StudentsGroup group21 = new StudentsGroup(21, "L2", 25, true, new ArrayList<Course>(Arrays.asList(course33, course34, course35, course37)));
		StudentsGroup group22 = new StudentsGroup(22, "L3", 25, true, new ArrayList<Course>(Arrays.asList(course33, course34, course35, course37)));
		StudentsGroup group23 = new StudentsGroup(23, "L4", 25, true, new ArrayList<Course>(Arrays.asList(course33, course34, course35, course37)));

		winterStudentsGroups = new ArrayList<StudentsGroup>(Arrays.asList(group1, group2, group3, group4, group5));
		summerStudentsGroups = new ArrayList<StudentsGroup>(Arrays.asList(group19, group20, group21, group22, group23));

		//Odsjeci
		Department dept1 = new Department("RI3 - Zimski",new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6)));
		Department dept2 = new Department("RI3 - Ljetni", new ArrayList<Course>(summerCourses));

		depts = new ArrayList<Department>(Arrays.asList(dept1));
		depts.forEach(x -> numberOfClasses += x.getCourses().size());

		return this;
	}

	public void setSemestar(String semestar) { this.semestar = semestar; }
	public void setGodina(String godina) { this.godina = godina; }
	public String getSemestar() { return semestar; }
	public String getGodina() { return godina; }

	public ArrayList<Room> getRooms() { return rooms; }
	public ArrayList<Professor> getProfessors() {
		if(semestar.equals("zimski"))
			return winterProfessors;
		else
			return summerProfessors;
	}
	public ArrayList<Course> getCourses() {
		if(semestar.equals("zimski"))
			return winterCourses;
		else
			return summerCourses;
		}
	public ArrayList<Department> getDepts() { return depts; }
	public ArrayList<MeetingTime> getMeetingTimes() {
		if(semestar.equals("zimski"))
			return winterMeetingTimes;
		else
			return summerMeetingTimes;
	}
	public ArrayList<StudentsGroup> getStudentsGroups() {
		if(semestar.equals("zimski"))
			return winterStudentsGroups;
		else
			return summerStudentsGroups;
	}
	public int getNumberOfClasses() { return this.numberOfClasses; }
}