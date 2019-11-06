package com.pegs.StudentManagementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class StudentManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementAppApplication.class, args);
	}

}
