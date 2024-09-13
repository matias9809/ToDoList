package com.mindhub.ToDoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToDoListApplication {
	@Bean
	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

}
