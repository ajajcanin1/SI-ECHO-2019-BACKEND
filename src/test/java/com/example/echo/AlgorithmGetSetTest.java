package com.example.echo;
import com.example.echo.DTO.Schedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import com.example.echo.DTO.Algorithm;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmGetSetTest {
    @Test
    public void testAlgorithm() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Schedule y= new Schedule(5,6,7,8);
        ArrayList<Schedule> lista=new ArrayList<>();
        lista.add(x); lista.add(y);
        Algorithm a= new Algorithm(1,2,3, x);
        a.setChromosomes(lista);
        Assert.assertTrue(a.getChromosomes()==lista);
    }
}
