package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDbApplication.class, args);
		System.out.println("This is main class");
	}
}
