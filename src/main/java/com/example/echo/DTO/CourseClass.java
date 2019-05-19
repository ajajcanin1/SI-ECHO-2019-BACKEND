package com.example.echo.DTO;
import java.util.List;
import java.util.Objects;

public class CourseClass {

    private int id;
    private int idProfessor;
    private int idCourse;
    private List<StudentsGroup> groups;
    private int numberOfSeats;
    private Boolean requiresLab;
    private int duration;

    public CourseClass(int id, int idProfessor, int idCourse, List<StudentsGroup> groups, int numberOfSeats, Boolean requiresLab, int duration) {
        this.id = id;
        this.idProfessor = idProfessor;
        this.idCourse = idCourse;
        this.groups = groups;
        this.numberOfSeats = numberOfSeats;
        this.requiresLab = requiresLab;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public List<StudentsGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<StudentsGroup> groups) {
        this.groups = groups;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Boolean getRequiresLab() {
        return requiresLab;
    }

    public void setRequiresLab(Boolean requiresLab) {
        this.requiresLab = requiresLab;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseClass that = (CourseClass) o;
        return id == that.id &&
                idProfessor == that.idProfessor &&
                idCourse == that.idCourse &&
                numberOfSeats == that.numberOfSeats &&
                duration == that.duration &&
                Objects.equals(groups, that.groups) &&
                Objects.equals(requiresLab, that.requiresLab);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProfessor, idCourse, groups, numberOfSeats, requiresLab, duration);
    }

   public Boolean groupsOverlap(CourseClass cc) {
       for (StudentsGroup sg: groups) {
           if(cc.groups.contains(sg)) {
               return true;
           }
           else return false;
       }
       return false;
   }
}