package com.example.echo.ga.v2.Domain;
public class MeetingTime {
	private int id;
    private String day;
    private String time;
    private int idProf;
    public MeetingTime(int id, String day, String time, int idProf) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.idProf = idProf;
    }
    public int getId() { return id; }
    public String getDay() { return day; }
    public String getTime() { return time; }
    public int getIdProf() { return idProf; }
}
