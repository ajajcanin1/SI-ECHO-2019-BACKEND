package com.example.echo.DTO;
import java.util.*;
import com.example.echo.DTO.Algorithm;
import com.example.echo.DTO.Configuration;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;



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

        /*
        for(int i = 0; i < newSlotsSize; i++) {
            List<CourseClass> l1 = new ArrayList<CourseClass>();
            this.slots.add(l1);
        }
        for(int i = this.criteria.size()-1; i < newCriteriaSize; i++) {
            this.criteria.add(null);
        }
        */

        int newSlotsSize = DAYS_NUM * DAY_HOURS * configuration.GetNumberOfRooms();
        int newCriteriaSize = 5 * configuration.GetNumberOfCourseClasses();
        this.slots=new ArrayList<List<CourseClass>>(newSlotsSize);
        this.criteria=new ArrayList<Boolean>(newCriteriaSize);
        this.classes = new HashMap<CourseClass, Integer>();
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
            for(int i = 0; i < newSlotsSize; i++) {
                List<CourseClass> l1 = new ArrayList<CourseClass>();
                this.slots.add(l1);
            }
            for(int i = this.criteria.size()-1; i < newCriteriaSize; i++) {
                this.criteria.add(null);
            }
            */

            int newSlotsSize = DAYS_NUM * DAY_HOURS * configuration.GetNumberOfRooms();
            int newCriteriaSize = 5 * configuration.GetNumberOfCourseClasses();
            this.slots=new ArrayList<List<CourseClass>>(newSlotsSize);
            this.criteria=new ArrayList<Boolean>(newCriteriaSize);
            this.classes = new HashMap<CourseClass, Integer>(); // Stavljeno radi testa MakeNewFromPrototype.

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
        n.CalculateFitness();
        return n;
    }
    //Kreira novi hromosom sa istim setupom, ali sa random odabranim kodom
    public Schedule MakeNewFromPrototype() {
        int size = this.slots.size();
        Schedule newChromosome = new Schedule(this, true);
        List<CourseClass> c = configuration.GetCourseClasses();
        for(CourseClass it : c) {
            int nr = configuration.GetNumberOfRooms();
            int dur = it.getDuration();
            int day = rand.nextInt()%DAYS_NUM;
            int room = rand.nextInt()%nr;
            int time = rand.nextInt()%(DAY_HOURS + 1 - dur);
            int pos = day * nr * DAY_HOURS + room * DAY_HOURS + time;

            for(int i = dur - 1; i >= 0; i--) {
                newChromosome.slots.get(pos + 1).add(it);
            }
            newChromosome.classes.put(it, pos);
        }
        newChromosome.CalculateFitness();
        return newChromosome;
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
        CalculateFitness(); //uradio Armin ali nije mergano
        //kada se merga stvarno pozvati metodu
    }
    void CalculateFitness()
    {
        // chromosome's score
        int score = 0;
        int numberOfRooms =2; // treba ovo izmijeniti
        int daySize = DAY_HOURS * numberOfRooms;
        int ci = 0;
        // check criterias and calculate scores for each class in schedule

        //if(classes.size()!=0) {
            for (Map.Entry<CourseClass, Integer> entry : classes.entrySet()) {
                int p = entry.getValue();
                int day = p / daySize;
                int time = p % daySize;
                int room = time / DAY_HOURS;
                time = time % DAY_HOURS;

                int dur = entry.getKey().getDuration();

                // check for room overlapping of classes
                Boolean ro = false;
                for (int i = dur - 1; i >= 0; i--) {
                    if (slots.get(p + i).size() > 1) {
                        ro = true;
                        break;
                    }
                }
                // on room overlaping
                if (!ro)
                    score++;

                criteria.set(ci, !ro);

                CourseClass cc = entry.getKey();
                Room r = new Room(1545, "S0", false, 50); // OVO NE VALJA --> Treba dobiti Room by ID (room)

                Boolean pomocnaVarijabla = false;
                // does current room have enough seats
                if (r.getNumberOfSeats() >= cc.getNumberOfSeats())
                    pomocnaVarijabla = true;

                criteria.set(ci + 1, pomocnaVarijabla);

                if (criteria.get(ci + 1))
                    score++;
                // does current room have computers if they are required
                criteria.set(ci + 2, !cc.getRequiresLab() || (cc.getRequiresLab() && r.getLab()));
                if (criteria.get(ci + 2))
                    score++;

                Boolean po = false, go = false, idi = false;
                // check overlapping of classes for professors and student groups
                for (int i = numberOfRooms, t = day * daySize + time; i > 0; i--, t += DAY_HOURS) {
                    // for each hour of class
                    for (int j = dur - 1; j >= 0; j--) {
                        // check for overlapping with other classes at same time
                        List<CourseClass> pomocnaLista = slots.get(t + j);
                        for (int k = 0; k < pomocnaLista.size(); k++) {
                            CourseClass b = pomocnaLista.get(k);
                            if (cc != b) {
                                // professor overlaps?
                                if (!po && cc.ProfessorOverlaps(b))
                                    po = true;

                                // student group overlaps?
                                if (!go && cc.groupsOverlap(b))
                                    go = true;

                                // both type of overlapping? no need to check more
                                if (po && go)
                                    idi = true;
                            }
                            if (idi)
                                break;
                        }
                        if (idi)
                            break;
                    }
                    if (idi)
                        break;
                }
                // professors have no overlaping classes?
                if (!po)
                    score++;
                criteria.set(ci + 3, !po);
                // student groups has no overlaping classes?
                if (!go)
                    score++;
                criteria.set(ci + 4, !go);

                ci += 5;
            }
        //}
        fitness = (float)score/(20*DAYS_NUM ); // NE VALJA --> Treba fitness = (float)score / ( Configuration::GetInstance().GetNumberOfCourseClasses() * DAYS_NUM );

    }
}

