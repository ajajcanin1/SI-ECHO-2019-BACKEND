package com.example.echo;
import com.example.echo.DTO.CourseClass;
import com.example.echo.DTO.StudentsGroup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseClassTest {
    @Test
    public void testPreklapanjaGrupa() throws Exception {
        List<StudentsGroup> tempLista = new ArrayList<>();
        List<StudentsGroup> tempLista2 = new ArrayList<>();
        StudentsGroup sg1= new StudentsGroup(1,"Student1", 23, null);
        StudentsGroup sg2= new StudentsGroup(2,"Student2", 26, null);
        tempLista.add(sg1);
        tempLista2.add(sg2);
        CourseClass cc1 = new CourseClass(1,  1,  1, tempLista, 34, true, 4 );
        CourseClass cc2 = new CourseClass(2,  2,  2, tempLista2, 40, true, 4 );
        Assert.assertFalse(cc1.groupsOverlap(cc2));

    }
}

