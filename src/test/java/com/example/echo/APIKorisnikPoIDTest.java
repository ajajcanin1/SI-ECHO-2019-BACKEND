package com.example.echo;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sun.security.krb5.Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest

public class APIKorisnikPoIDTest {
    public Boolean pozoviZaKorisnikePoId() throws Exception {
        String url = "http://localhost:31905/si2019/echo/korisnici/5";
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
        JSONObject o = new JSONObject(response.toString());
        if(o!=null) return true;
        return false;
	}
       
    @Test
    public void testKorisniciPoId() throws Exception {
        Boolean provjera=false;
        try {
            provjera=pozoviZaKorisnikePoId();
		} catch (Exception e) {
			e.printStackTrace();
        }       
        Assert.assertTrue(provjera==true);
    }
}