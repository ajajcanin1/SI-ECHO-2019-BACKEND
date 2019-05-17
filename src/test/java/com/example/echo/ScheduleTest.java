package com.example.echo;

import com.example.echo.DTO.Course;
import com.example.echo.DTO.CourseClass;
import com.example.echo.DTO.Schedule;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleTest {
    @Test
    public void testCopyConstructor() throws Exception {
        Schedule x = new Schedule(1,2,3,4);
        Schedule y = x;

        Assert.assertEquals(x, y);
    }

}
