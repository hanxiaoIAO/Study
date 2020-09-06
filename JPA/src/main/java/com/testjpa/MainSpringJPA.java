package com.testjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.testjpa")
public class MainSpringJPA {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MainSpringJPA.class);
		app.run(args);
	}
}
