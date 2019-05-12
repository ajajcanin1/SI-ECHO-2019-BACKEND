package com.example.echo.Entity;
import java.util.Objects;

public class Room {
    private int id;
    private String name;
    private Boolean lab;
    private int numberOfSeats;

    public Room(int id, String name, Boolean lab, int numberOfSeats) {
        this.id = id;
        this.name = name;
        this.lab = lab;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLab() {
        return lab;
    }

    public void setLab(Boolean lab) {
        this.lab = lab;
    }


    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id &&
                numberOfSeats == room.numberOfSeats &&
                Objects.equals(name, room.name) &&
                Objects.equals(lab, room.lab);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lab, numberOfSeats);
    }

//metoda za provjeru da li sala ima opremu koja je neophodna
public Boolean imaOpremu(){
    if(this.lab == true)return true;
    return false;
}
}
