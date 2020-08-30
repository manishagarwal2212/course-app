package com.edukart.course.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class CourseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseAppApplication.class, args);
	}
	
	@GetMapping()
	String hello() {
		return "Welcome to content service";
	}

}
