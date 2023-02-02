package com.elijah.vacationtourproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VacationTourProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacationTourProjectApplication.class, args);
	}

}
