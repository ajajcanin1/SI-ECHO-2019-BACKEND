package com.example.echo;
import com.example.echo.DTO.Algorithm;
import com.example.echo.DTO.Schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import java.util.ArrayList;
@RunWith(SpringRunner.class)
@SpringBootTest

public class GetBestChromosomeTest {
    @Test
    public void testOptimalniHromosom() throws Exception {
        Schedule sh = new Schedule(2,2,2,2);
        Algorithm temp = new Algorithm(4, 4, 4, sh);
        ArrayList<Schedule> tempLista = new ArrayList<>();
        Schedule rasp=new Schedule(1,2,3,4);
        tempLista.add(rasp);
        temp.setChromosomes(tempLista);
        temp.AddToBest(0);
        Schedule kon= temp.GetBestChromosome();
        Assert.assertNotNull(kon);
        
    }
}