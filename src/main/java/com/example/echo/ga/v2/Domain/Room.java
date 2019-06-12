package com.example.echo.ga.v2.Domain;
public class Room {
	private String name;
	private int seatingCapacity;
	public Room(String name, int seatingCapacity) {
		this.name = name;
		this.seatingCapacity = seatingCapacity;
	}
	public String getName() { return name; }
	public int getSeatingCapacity() { return seatingCapacity; }
}
