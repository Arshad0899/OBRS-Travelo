package com.obrs.travels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObrsApplication.class, args);
		System.out.println("Connected");
	}

}
