package com.edukart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CourseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseAppApplication.class, args);
	}
	
	@GetMapping("/")
	String hello() {
		return "Welcome to content service";
	}

}

