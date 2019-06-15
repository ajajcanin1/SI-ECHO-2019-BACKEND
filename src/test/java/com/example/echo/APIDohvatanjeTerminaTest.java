package com.example.echo;

import com.example.echo.ga.v2.Data;
import com.example.echo.ga.v2.Domain.MeetingTime;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sun.security.krb5.Config;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest

public class APIDohvatanjeTerminaTest {
       
    @Test
    public void testTermini() throws Exception {
        ArrayList<MeetingTime> listaP=new ArrayList<MeetingTime>();
        Data d= new Data();
        try {
            listaP.addAll(d.pozoviZaTermine());
		} catch (Exception e) {
			e.printStackTrace();
        }       
        Assert.assertTrue(listaP.size()!=0);
    }
}