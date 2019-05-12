package com.example.echo.Entity;
import java.util.HashMap;
import java.util.Vector;
import java.util.List;
import java.util.Random;
import com.example.echo.Entity.Room;
import com.example.echo.Entity.CourseClass;
import java.io.*; 
import java.util.*;
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

    // provjeriti
    int DAY_HOURS=12;


    float GetFitness()
    {
        return fitness;
    }

    void CalculateFitness()
    {
        // chromosome's score
        int score = 0;
        int numberOfRooms =2; // treba ovo izmijeniti
        int daySize = DAY_HOURS * numberOfRooms;
        int ci = 0;
        // check criterias and calculate scores for each class in schedule
        for (Map.Entry<CourseClass, Integer> entry : classes.entrySet()) {
            int p = entry.getValue();
            int day = p / daySize;
            int time = p % daySize;
            int room = time / DAY_HOURS;
            time = time % DAY_HOURS;

            int dur = entry.getKey().getDuration();

            // check for room overlapping of classes
            Boolean ro = false;
            for( int i = dur - 1; i >= 0; i-- )
            {
                if( slots.get( p + i ).size() > 1 )
                {
                    ro = true;
                    break;
                }
            }
            // on room overlaping
            if( !ro )
                score++;

            criteria.set(ci,!ro);

            CourseClass cc= entry.getKey();
            Room r=new Room(1545,"S0",false,50); // OVO NE VALJA --> Treba dobiti Room by ID (room)

            Boolean pomocnaVarijabla=false;
            // does current room have enough seats
            if(r.getNumberOfSeats() >= cc.getNumberOfSeats())
                pomocnaVarijabla=true;

            criteria.set( ci + 1,pomocnaVarijabla );

            if( criteria.get( ci + 1 ) )
                score++;
            // does current room have computers if they are required
            criteria.set(ci+2,!cc.getRequiresLab() || ( cc.getRequiresLab() && r.getLab() ));
            if( criteria.get( ci + 2 ) )
                score++;

            Boolean po=false, go=false,idi=false;
            // check overlapping of classes for professors and student groups
            for( int i = numberOfRooms, t = day * daySize + time; i > 0; i--, t += DAY_HOURS )
            {
                // for each hour of class
                for( int j = dur - 1; j >= 0; j-- )
                {
                    // check for overlapping with other classes at same time
                    List<CourseClass> pomocnaLista= slots.get(t+j);
                    for(int k=0;k<pomocnaLista.size();k++)
                    {
                        CourseClass b=pomocnaLista.get(k);
                        if(cc!=b)
                        {
                            // professor overlaps?
                            if( !po && cc.ProfessorOverlaps(b) )
                                po = true;

                            // student group overlaps?
                            if( !go && cc.groupsOverlap( b ) )
                                go = true;

                            // both type of overlapping? no need to check more
                            if( po && go )
                                idi=true;
                        }
                        if( idi )
                            break;
                    }
                    if( idi )
                        break;
                }
                if( idi )
                    break;
            }
            // professors have no overlaping classes?
            if( !po )
                score++;
            criteria.set(ci+3,!po);
            // student groups has no overlaping classes?
            if( !go )
                score++;
            criteria.set( ci + 4,!go);

            ci += 5;
        }

        fitness = (float)score; // NE VALJA --> Treba fitness = (float)score / ( Configuration::GetInstance().GetNumberOfCourseClasses() * DAYS_NUM );

    }
}