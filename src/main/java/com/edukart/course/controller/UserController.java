package com.edukart.course.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edukart.course.repo.UserDetailsRepo;
import com.edukart.models.UserDetails;

@RestController("/api")
public class UserController {
	
	@Autowired
	UserDetailsRepo userRepo;
	
	@PostMapping("/users/")
	public UserDetails registerUser(@RequestBody UserDetails userDetailsDto) {
		return userRepo.save(userDetailsDto);
	}
	
	@GetMapping("/users/")
	public List<UserDetails> getUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<UserDetails> getUser(@PathVariable long id) {
		return userRepo.findById(id);
	}

}
