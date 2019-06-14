package com.example.echo.ga.v2.Domain;
public class Professor {
	private int id;
    private String name;
    private boolean assistent;

    public Professor(int id, String name, boolean assistent){
        this.id = id;
        this.name = name;
        this.assistent = assistent;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean isAssistent() { return assistent; }
    public String toString() { return name; }
}
