package com.example.echo.Entity;
import java.util.HashMap;
import java.util.Vector;
import java.util.List;
import java.util.Random;
import com.example.echo.Entity.Room;
import com.example.echo.Entity.CourseClass;
import java.io.*; 
import java.util.*;
// enum vrijednost za stanje algoritma
public enum AlgorithmState
{
	AS_USER_STOPED,
	AS_CRITERIA_STOPPED,
	AS_RUNNING
}
public class Schedule {
    private int numberOfCrossoverPoints;
    private int mutationSize;
    private int crossoverProbability;
    private int mutationProbability;
    private float fitness;
    private Vector<Boolean> criteria;
    private Vector<List<CourseClass>> slots;
    private HashMap<CourseClass, Integer> classes;

// Initializes chromosomes with configuration block (setup of chromosome)
public Schedule(int numberOfCrossoverPoints, int mutationSize, int crossoverProbability, int mutationProbability){
    this.numberOfCrossoverPoints = numberOfCrossoverPoints;
    this.mutationSize = mutationSize;
    this.crossoverProbability = crossoverProbability;
    this.mutationProbability = mutationProbability;
    this.fitness = 0;
    //ubaciti
    //slots.resize(5 * 12 * GetNumberOfRooms());
    //criteria.resize(5 * GetNumberOfCourseClasses());
}
// Copy constructor ubaciti
public Schedule(const Schedule c, bool setUpOnly){
}
// Makes copy of chromosome
Schedule MakeCopy(bool setupOnly){
	return new Schedule( this, setupOnly);
}
/*
// Performs mutation on chromosome 
void Mutation()
{
    Random rand = new Random();
	if(rand.nextInt(100) > mutationProbability)return;
	int numberOfClasses = classes.size();
	int size = slots.size();
	for(int i = mutationSize; i > 0; i--)
	{
		int mpos = rand.nextInt(numberOfClasses);
		int pos1 = 0;
		Iterator it = classes.iterator();
		for( ; mpos > 0; it.next(), mpos--)
		;
		pos1 = (int) it.get();
		CourseClass cc1 = (CourseClass) it.get();
		int nr =  10; //Configuration::GetInstance().GetNumberOfRooms()
		int dur = 2;  //cc1->GetDuration();
		int day = rand.nextInt(5);
		int room = rand.nextInt(nr);
		int time = rand.nextInt(12 + 1 - dur);
		int pos2 = day * nr * 12 + room * 12 + time;
		for(int i = dur - 1; i >= 0; i-- )
		{
			List<CourseClass> cl = slots.get(pos1 + i);
			ListIterator iterator = cl.listIterator();
				while(iterator.hasNext()) {
   				if(iterator.next() == cc1)
				   {
					   cl.remove(cc1);
					   break;
				   }
			}
			slots.add(pos2 + i, cc1);
		}
		classes[cc1] = pos2;
	}
	CalculateFitness();
}
void CalculateFitness(){}
}
*/
// u vs zajedno s schedule klasom stavljeno
private class Algorithm{
	private Vector<Schedule> chromosomes;
	private Vector<bool> bestFlags;
	private Vector<int> bestChromosomes;
	private int currentBestSize;
	private int replaceByGeneration;
	private Schedule prototype;
	private int currentGeneration;
	static Algorithm instance;
	private AlgorithmState state;
}
