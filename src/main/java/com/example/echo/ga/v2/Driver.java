package com.example.echo.ga.v2;

import com.example.echo.ga.v2.Domain.Class;
import com.example.echo.ga.v2.Domain.StudentsGroup;

import java.util.ArrayList;


public class Driver {
	public static final int POPULATION_SIZE = 9;
	public static final double MUTATION_RATE = 0.1;
	public static final double CROSSOVER_RATE = 0.9;
	public static final int TOURNAMENT_SELECTION_SIZE = 3;
	public static final int NUMB_OF_ELITE_SCHEDULES = 1;
	private Data data;
	public void Start(String semestar, String godina) {
		Driver driver = new Driver();
		driver.data = new Data();
		driver.data.setGodina(godina);
		driver.data.setSemestar(semestar);
		int generationNumber = 0;
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data);
		Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
		while(true) {
			generationNumber++;
			if(population.getSchedules().get(0).getFitness() != 1.0)
				population = geneticAlgorithm.evolve(population).sortByFitness();
			else {
				driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
				break;
			}
		}
	}
	private void printScheduleAsTable(Schedule schedule, int generation) {
		ArrayList<Class> classes = schedule.getClasses();
		ArrayList<StudentsGroup> groups = data.getStudentsGroups();

		//raspored po studentskim grupama
		System.out.println("---------------------------------------------------------------");
		groups.forEach(sg -> {
			System.out.print("                     Grupa ");
			System.out.print(String.format(sg.getName()));
			if(sg.isLabGroup())
				System.out.print(" - Vježbe ");
			else
				System.out.print((" - Predavanja "));
			System.out.println("(" + sg.getNumberOfStudents() + " studenata)");
			System.out.println("---------------------------------------------------------------");
			sg.getCourses().forEach(course -> {
				System.out.print("Predmet: ");
				System.out.println(String.format(course.getName() +
						" ("+course.getNumber()+")"));
				System.out.print("Sala: ");
				classes.forEach(c -> {
					if(c.getStudentsGroup().getId() == sg.getId() && c.getCourse().getName() == course.getName()) {
						System.out.println(String.format(c.getRoom().getName()));
						if(c.getProfessor().isAssistent())
							System.out.print("Asistent: ");
						else
							System.out.print("Profesor: ");
						System.out.println(String.format(c.getProfessor().getName()));
						System.out.print("Vrijeme: ");
						System.out.print(printDay(c.getMeetingTime().getDay()) + " ");
						System.out.println(c.getMeetingTime().getTime());
					}
				});
				System.out.println("---------------------------------------------------------------");
			});
		});

		//raspored po terminima
		/*classes.forEach(x -> {
			int majorIndex = data.getStudentsGroups().indexOf(x.getStudentsGroup());
			int coursesIndex = data.getCourses().indexOf(x.getCourse());
			int roomsIndex = data.getRooms().indexOf(x.getRoom());
			int instructorsIndex = data.getProfessors().indexOf(x.getProfessor());
			int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
			System.out.print("Grupa ");
			System.out.print(String.format(data.getStudentsGroups().get(majorIndex).getName()));
			if(x.getRoom().isLab())
				System.out.print(" - Vježbe\n");

			else
				System.out.print(" - Predavanja\n");
			System.out.println("Broj studenata: " + data.getStudentsGroups().get(majorIndex).getNumberOfStudents());
			System.out.print("Predmet: ");
			System.out.println(String.format(data.getCourses().get(coursesIndex).getName() +
					" ("+data.getCourses().get(coursesIndex).getNumber()+")"));
			System.out.print("Sala: ");
			System.out.println(String.format(data.getRooms().get(roomsIndex).getName()));
			if(x.getProfessor().isAssistent())
				System.out.print("Asistent: ");
			else
				System.out.print("Profesor: ");
			System.out.println(String.format(data.getProfessors().get(instructorsIndex).getName()));
			System.out.print("Vrijeme: ");
			System.out.print(data.getMeetingTimes().get(meetingTimeIndex).getDay() + " ");
			System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTime());
			System.out.println("---------------------------------------------------------------");
		});*/
		if (schedule.getFitness() == 1) System.out.println("> Optimalni raspored je pronađen ");
		System.out.println("---------------------------------------------------------------");
	}
	private String printDay(String day) {
		if(day == "PON")
			return("Ponedjeljak");
		else if(day == "UTO")
			return("Utorak");
		else if(day == "SRI")
			return("Srijeda");
		else if(day == "CET")
			return("Četvrtak");
		else
			return("Petak");
	}
}
