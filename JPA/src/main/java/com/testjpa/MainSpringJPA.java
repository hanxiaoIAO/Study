package com.testjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainSpringJPA {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MainSpringJPA.class);
		app.run(args);
	}
}
