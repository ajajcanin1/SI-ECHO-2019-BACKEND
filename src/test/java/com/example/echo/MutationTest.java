package com.example.echo;
import com.example.echo.DTO.Schedule;
import java.util.HashMap;
import com.example.echo.DTO.CourseClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import com.example.echo.DTO.StudentsGroup;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import sun.security.krb5.Config;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class MutationTest {
    @Test
    public void testMutation() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        HashMap<CourseClass, Integer> classes= new HashMap<>();
        List<StudentsGroup> lista = new ArrayList<>();
        List<StudentsGroup> lista2 = new ArrayList<>();
        StudentsGroup s1= new StudentsGroup(1,"Student1", 23, null);
        StudentsGroup s2= new StudentsGroup(2,"Student2", 26, null);
        lista.add(s1);
        lista2.add(s2);
        CourseClass cc1 = new CourseClass(1,  1,  1, lista, 34, true, 1);
        CourseClass cc2 = new CourseClass(2,  2,  2, lista2, 40, true, 1);
        classes.put(cc1, 1);
        classes.put(cc2, 2);
        List<CourseClass> l= new ArrayList<>();
        l.add(cc1);
        List<CourseClass> l2= new ArrayList<>();
        l2.add(cc2);
        ArrayList<List<CourseClass>> slots= new ArrayList<>();
        slots.add(l); slots.add(l2); 
        x.setClasses(classes);
        x.setSlots(slots);
        x.Mutation();
        Assert.assertTrue(x.getClasses().get(cc1)!=1 || x.getClasses().get(cc2)!=2);
    }
}
