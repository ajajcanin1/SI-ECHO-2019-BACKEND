package com.example.echo.DTO;
import java.util.*;

enum AlgorithmState
{
    AS_USER_STOPED,
    AS_CRITERIA_STOPPED,
    AS_RUNNING
};

public class Schedule {
    private int numberOfCrossoverPoints;
    private int mutationSize;
    private int crossoverProbability;
    private int mutationProbability;
    private float fitness;
    private ArrayList<Boolean> criteria;
    private ArrayList<List<CourseClass>> slots;
    private HashMap<CourseClass, Integer> classes;

    static int DAYS_NUM = 5;
    static int DAY_HOURS = 12;

    static Configuration configuration = new Configuration();
    Random rand = new Random();


    // Initializes chromosomes with configuration block (setup of chromosome)
    public Schedule(int numberOfCrossoverPoints, int mutationSize, int crossoverProbability, int mutationProbability){
        this.numberOfCrossoverPoints = numberOfCrossoverPoints;
        this.mutationSize = mutationSize;
        this.crossoverProbability = crossoverProbability;
        this.mutationProbability = mutationProbability;
        this.fitness = 0;

        this.criteria = new ArrayList<Boolean>();
        this.slots = new ArrayList<List<CourseClass>>();
        this.classes = new HashMap<CourseClass, Integer>();
        //ubaciti
        //slots.resize(5 * 12 * GetNumberOfRooms());
        //criteria.resize(5 * GetNumberOfCourseClasses());
    }

    public ArrayList<Boolean> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Boolean> criteria) {
        this.criteria = criteria;
    }

    public ArrayList<List<CourseClass>> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<List<CourseClass>> slots) {
        this.slots = slots;
    }

    public HashMap<CourseClass, Integer> getClasses() {
        return classes;
    }

    public void setClasses(HashMap<CourseClass, Integer> classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return numberOfCrossoverPoints == schedule.numberOfCrossoverPoints &&
                mutationSize == schedule.mutationSize &&
                crossoverProbability == schedule.crossoverProbability &&
                mutationProbability == schedule.mutationProbability &&
                Float.compare(schedule.fitness, fitness) == 0 &&
                Objects.equals(criteria, schedule.criteria) &&
                Objects.equals(slots, schedule.slots) &&
                Objects.equals(classes, schedule.classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCrossoverPoints, mutationSize, crossoverProbability, mutationProbability, fitness, criteria, slots, classes, rand);
    }

    // Copy constructor
    public Schedule(Schedule c, Boolean setupOnly) {

        if(!setupOnly) {
            this.fitness = c.fitness;
            this.criteria = c.criteria;
            this.slots = c.slots;
            this.classes = c.classes;
        }
        else {
                /*
                int newSlotsSize = DAYS_NUM * DAY_HOURS * configuration.GetNumberOfRooms();
                int newCriteriaSize = 5 * configuration.GetNumberOfCourseClasses();

                for(int i = this.slots.size(); i < newSlotsSize; i++) {
                    List<CourseClass> l1 = new ArrayList<CourseClass>();
                    this.slots.add(l1);
                }
                for(int i = this.criteria.size(); i < newCriteriaSize; i++) {
                    this.criteria.add(null);
                }

                 */
        }
        this.numberOfCrossoverPoints = c.numberOfCrossoverPoints;
        this.mutationSize = c.mutationSize;
        this.crossoverProbability = c.crossoverProbability;
        this.mutationProbability = c.mutationProbability;

    }

    // Makes copy of chromosome
    public Schedule MakeCopy(Boolean setupOnly) {
        return new Schedule(this, setupOnly);
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
}