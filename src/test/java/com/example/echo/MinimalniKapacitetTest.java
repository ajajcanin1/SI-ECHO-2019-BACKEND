package com.example.echo;
import com.example.echo.DTO.CourseClass;
import com.example.echo.DTO.StudentsGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import sun.security.krb5.Config;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class MinimalniKapacitetTest {
    @Test
    public void testMinimalniKapacitet() throws Exception {
        CourseClass temp = new CourseClass(2,  2,  2, null, 40, true, 4 );
        List<CourseClass> lista=new ArrayList<>();
        lista.add(temp);
        StudentsGroup grupa= new StudentsGroup(1, "grupa2", 18, lista);
        Boolean provjera=grupa.zadovoljenjeKapaciteta();
        assertTrue(provjera==true);
        CourseClass c = new CourseClass(2,  2,  2, null, 40, true, 4 );
        List<CourseClass> lista2=new ArrayList<>();
        lista2.add(c);
        StudentsGroup grupa2= new StudentsGroup(1, "grupa2", 13, lista2);
        Boolean provjera2=grupa2.zadovoljenjeKapaciteta();
        assertTrue(provjera2==false);
    }
}