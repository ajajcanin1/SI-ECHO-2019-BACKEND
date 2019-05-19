package com.example.echo;
import com.example.echo.DTO.Schedule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleTest {
    @Test
    public void testCopyConstructor() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Schedule y = x;

        Assert.assertEquals(x, y);
    }

    @Test
    public void testMakeCopy() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Schedule y = new Schedule(5,6,7,8);

        y = x.MakeCopy(false);
        Assert.assertEquals(x, y);
    }
}
