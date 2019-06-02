package com.example.echo;
import com.example.echo.DTO.CourseClass;
import com.example.echo.DTO.Schedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleTest {
    @Test
    public void testCopyConstructor() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Schedule y = x;

        Assert.assertEquals(x, y);
    }

    @Test
    public void testMakeCopy() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Schedule y = new Schedule(5,6,7,8);

        y = x.MakeCopy(false);
        Assert.assertEquals(x, y);
    }

/*
    @Test
    public void testCrossover() throws Exception {
        Schedule x = new Schedule(5,2,7,8);
        Schedule y = new Schedule(5,6,7,8);

        Schedule child = x.Crossover(y);
        //PLS.
       // CourseClass cc1 = new CourseClass(1,  1,  1, tempLista, 34, true, 4 );
        //CourseClass cc2 = new CourseClass(2,  2,  2, tempLista2, 40, true, 4 );
       // x.setClasses();
        Assert.assertNotEquals(child, x);
    }*/


    @Test
    public void testMakeNewFromPrototype() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Schedule y = new Schedule(5,6,7,8);

        ArrayList<List<CourseClass>> tempSlots1 = new ArrayList<List<CourseClass>>();
        for(int j = 0; j < 3; j++) {
            List<CourseClass> l1 = new ArrayList<CourseClass>();
            for(int i=1; i<10; i++) {
                CourseClass c1 = new CourseClass(i,i,i,null,20 + i,false,4 + i);
                l1.add(c1);
            }
            tempSlots1.add(l1);
        }
        x.setSlots(tempSlots1);
        System.out.println(x.getSlots().size());
        Assert.assertNotEquals(x, x.MakeNewFromPrototype());
    }
    @Test
    public void instancaAlgoritma() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Assert.assertNotNull(x.getInstance());
    }

}
