package com.example.echo.ga.v2.Domain;
public class MeetingTime {
	private int id;
    private String time;
    private int idProf;
    public MeetingTime(int id, String time, int idProf) {
        this.id = id;
        this.time = time;
        this.idProf = idProf;
    }
    public int getId() { return id; }
    public String getTime() { return time; }
    public int getIdProf() { return idProf; }
}
