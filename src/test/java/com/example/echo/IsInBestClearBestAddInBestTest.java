package com.example.echo;
import com.example.echo.DTO.Algorithm;
import com.example.echo.DTO.Schedule;
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

public class IsInBestClearBestAddInBestTest {
    @Test
    public void testMetoda() throws Exception {
        Schedule sh = new Schedule(2,2,2,2);
        Algorithm temp = new Algorithm(4, 4, 4, sh);
        Boolean provjera = temp.IsInBest(1);
        assertTrue(provjera == false);
        temp.AddToBest(1);
        provjera = temp.IsInBest(1);
        assertTrue(provjera == true);
        temp.AddToBest(2);
        provjera = temp.IsInBest(2);
        assertTrue(provjera == false);
        temp.ClearBest();
        provjera = temp.IsInBest(1);
        assertTrue(provjera == false);
    }
}