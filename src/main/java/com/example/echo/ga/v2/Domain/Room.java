package com.example.echo.ga.v2.Domain;
public class Room {
	private String name;
	private int seatingCapacity;
	private boolean lab;
	public Room(String name, int seatingCapacity, boolean lab) {
		this.name = name;
		this.seatingCapacity = seatingCapacity;
		this.lab = lab;
	}
	public String getName() { return name; }
	public int getSeatingCapacity() { return seatingCapacity; }
	public boolean isLab() { return lab; }
}
