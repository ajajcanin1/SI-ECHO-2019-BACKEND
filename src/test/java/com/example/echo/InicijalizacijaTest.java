package com.example.echo;
import com.example.echo.DTO.Algorithm;
import com.example.echo.DTO.Schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
@RunWith(SpringRunner.class)
@SpringBootTest

public class InicijalizacijaTest {
    @Test
    public void testMetoda() throws Exception {
        Schedule sh = new Schedule(2,2,2,2);
        Algorithm temp = new Algorithm(4, 4, 4, sh);
        List<Algorithm> tempLista = new ArrayList<>();
        tempLista.add(temp);
        assertThat(tempLista, hasItems(temp));
    }
}