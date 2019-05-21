package com.example.echo.DTO;
import java.util.*;
import com.example.echo.DTO.Algorithm;
import com.example.echo.DTO.Configuration;

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
    public float GetFitness(){
        return fitness;
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

    // Performes crossover operation using to chromosomes and returns pointer to offspring
    public Schedule Crossover(Schedule parent2) {

        if (rand.nextInt()%100 > this.crossoverProbability) {
            return new Schedule(this, false);
        }
        Schedule n = new Schedule(this, true);
        int size = this.classes.size();
        ArrayList<Boolean> cp=new ArrayList(size);

        for (int i = this.numberOfCrossoverPoints; i>0; i++) {
            while (true) {
                int p=rand.nextInt()%size;
                if (!cp.get(p)) {
                    cp.add(p,true);
                    break;
                }
            }
        }
        Map<CourseClass, Integer> mapChild = this.classes;
        Map<CourseClass, Integer> mapParent = parent2.classes;

        Map.Entry<CourseClass, Integer> it1 = mapChild.entrySet().iterator().next();
        Map.Entry<CourseClass, Integer> it2 = mapParent.entrySet().iterator().next();

        Boolean first = rand.nextInt()%2 == 0;
        for(int i = 0; i < size; i++) {
            if(first) {
                n.classes.put(it1.getKey(), it1.getValue());
                for(int j = it1.getKey().getDuration() - 1; j >= 0; j-- ) {
                    int poc = it1.getValue() + j;
                    List<CourseClass> temp = n.slots.get(poc);
                    temp.add(it1.getKey());
                    n.slots.set(poc, temp);
                }
            }
            else {
                n.classes.put(it2.getKey(), it2.getValue());
                for(int j = it2.getKey().getDuration() - 1; j >= 0; j-- ) {
                    int poc = it2.getValue() + j;
                    List<CourseClass> temp = n.slots.get(poc);
                    temp.add(it2.getKey());
                    n.slots.set(poc, temp);
                }
            }
            if(cp.get(i)) {
                first = !first;
            }
            it1 = mapChild.entrySet().iterator().next();
            it2 = parent2.classes.entrySet().iterator().next();
        }
        //n.CalculateFitness();
        return n;
    }

    // Performs mutation on chromosome (provjeriti)
    public void Mutation(){
        //int random=rand.nextInt(1000);
        int random=3; //hardkodirana vrijednost za testiranje, jer se radi sa random brojevima
        // zbog uslova da random%100 mora bit < mutationProbability
        // test napisan kao da je random%100 < mutationProbability
        if(random%100>mutationProbability)
        return;
        int numberOfClasses=classes.size();
        for(int i=mutationSize; i>0; i--){
            int mpos = random % numberOfClasses;
            int pos1 = 0;
            int br=0;
            CourseClass cc1=null;
          for(CourseClass key :classes.keySet()){
              if(br==mpos){
                cc1=key;
                pos1=classes.get(key);
                break;
              }
              br++;
          }
          int nr= configuration.GetNumberOfRooms();
          int dur=cc1.getDuration();
          int day=random % DAYS_NUM;
          int room=random%nr;
          int time= random % ( DAY_HOURS + 1 - dur );
          int pos2 = day * nr * DAY_HOURS + room * DAY_HOURS + time;
          for(int j=dur-1; j>=0; j--){
              if(pos1+j<slots.size()){
              List<CourseClass> cl= slots.get(pos1+j);
              for(int k=0; k<cl.size(); k++){
                  if(cl.get(k)==cc1){
                      cl.remove(k);
                      break;
                  }
              }
              List<CourseClass> nova= new ArrayList<>();
              nova.add(cc1);
              slots.add(pos2+j, nova);
            }
          }
          classes.put(cc1, pos2);
        }
        //CalculateFitness(); //uradio Armin ali nije mergano
        //kada se merga stvarno pozvati metodu
    }   
}