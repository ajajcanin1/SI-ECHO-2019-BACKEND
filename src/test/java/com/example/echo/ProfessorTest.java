package com.example.echo;
import com.example.echo.DTO.CourseClass;
import com.example.echo.DTO.Professor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfessorTest {
    @Test
    public void testDodavanjePredmeta() throws Exception {
        CourseClass temp = new CourseClass(2,  2,  2, null, 40, true, 4 );
        List<CourseClass> tempLista = new ArrayList<>();
        tempLista.add(temp);
        Professor p = new Professor(1, "Envera Husagic", tempLista);
        CourseClass c = new CourseClass(1,  1,  1, null, 40, true, 4 );
        p.addCourseClass(c);
        List<CourseClass>listCC = p.getCourseClasses();
        assertThat(listCC, hasItems(c));
    }
}