//testiranje funkcija iz data.java i test apija
package com.example.echo;
import com.example.echo.Entity.Kabinet;
import com.example.echo.Entity.Predmet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.example.echo.ga.v2.Domain.*;
import com.example.echo.ga.v2.Data;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.net.*;
import org.json.JSONArray;
import sun.security.krb5.Config;

import java.util.ArrayList;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest

public class PredmetiAPIpozoviPredmeteTest{
    @Test
    public void testApi() throws Exception {
        ArrayList<Course> nova = new ArrayList<Course>();
        Data d = new Data();
        try{
            nova.addAll(d.pozoviPredmete());
        }catch(Exception e){
            e.printStackTrace();
        }      
        Assert.assertTrue(nova.size() != 0);
    }
}