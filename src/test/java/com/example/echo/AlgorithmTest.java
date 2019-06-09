package com.example.echo;

import com.example.echo.DTO.Algorithm;
import com.example.echo.DTO.CourseClass;
import com.example.echo.DTO.Schedule;
import com.example.echo.DTO.StudentsGroup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import sun.security.krb5.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class AlgorithmTest {
    @Test
    public void testStarta() throws Exception {
        Schedule x = new Schedule(5,2,7,8);
        Schedule y = new Schedule(5,6,7,8);


        List<StudentsGroup> tempLista = new ArrayList<>();
        List<StudentsGroup> tempLista2 = new ArrayList<>();

        CourseClass cc1 = new CourseClass(1,  1,  1, tempLista, 34, true, 4 );
        CourseClass cc2 = new CourseClass(2,  2,  2, tempLista2, 40, true, 4 );

        StudentsGroup sg1= new StudentsGroup(1,"Student1", 23, null);
        StudentsGroup sg2= new StudentsGroup(2,"Student2", 26, null);

        tempLista.add(sg1);
        tempLista2.add(sg2);

        HashMap<CourseClass, Integer> h1 = new HashMap<CourseClass, Integer>();
        HashMap<CourseClass, Integer> h2 = new HashMap<CourseClass, Integer>();

        h1.put(cc1, 1);
        h2.put(cc2, 1);

        x.setClasses(h1);
        // y.setClasses(h2);


        //Schedule x = new Schedule(1, 2, 3, 4);
        Algorithm a = new Algorithm(1, 7, 4, x);
        a.Start();
        Assert.assertTrue(Algorithm.AlgorithmState.AS_CRITERIA_STOPPED == a.getState());
    }
}