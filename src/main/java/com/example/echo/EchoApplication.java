package com.example.echo;

import com.example.echo.ga.v2.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EchoApplication {


	public static void main(String[] args) {
		SpringApplication.run(EchoApplication.class, args);
		Driver driver = new Driver();
		driver.Start();
	}
}
