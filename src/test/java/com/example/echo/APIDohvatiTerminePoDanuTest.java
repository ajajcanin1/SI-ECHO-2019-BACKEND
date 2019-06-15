package com.example.echo;

import com.example.echo.Entity.Korisnik;
import com.example.echo.ga.v2.Data;
import com.example.echo.ga.v2.Domain.MeetingTime;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sun.security.krb5.Config;

import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest

public class APIDohvatiTerminePoDanuTest {
    public Boolean pozoviZaTerminePoDanu() throws Exception {
		String url = "http://localhost:31905/si2019/echo/terminpodanu/Pon";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		System.out.println("Salje se zahtjev na link" + url);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputline;
		StringBuffer response = new StringBuffer();
		while ((inputline = in.readLine()) != null) {
			response.append(inputline);
		}
		in.close();
		System.out.println(response.toString());
		JSONArray niz=new JSONArray(response.toString());	
        if(niz.length()!=0) return true;
        return false;
	}
       
    @Test
    public void testTerminiPoDanu() throws Exception {
        Boolean provjera=false;
        try {
            provjera=pozoviZaTerminePoDanu();
		} catch (Exception e) {
			e.printStackTrace();
        }       
        Assert.assertTrue(provjera==true);
    }
}