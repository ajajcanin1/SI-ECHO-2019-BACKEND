package com.example.echo;
import com.example.echo.DTO.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest

public class OpremaTest {
    @Test
    public void testProvjeraOpreme() throws Exception {
        Room temp = new Room(2, "S0", true, 60 );
        List<Room> tempLista = new ArrayList<>();
        tempLista.add(temp);
        Boolean provjera = temp.imaOpremu();
        assertTrue(provjera == true);
    }
}