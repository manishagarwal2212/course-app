package com.edukart.course.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edukart.course.entity.UserDetailsDto;
import com.edukart.course.repo.UserDetailsRepo;

@RestController
public class UserController {
	
	@Autowired
	UserDetailsRepo userRepo;
	
	@PostMapping("/users/")
	public UserDetailsDto registerUser(@RequestBody UserDetailsDto userDetailsDto) {
		return userRepo.save(userDetailsDto);
	}
	
	@GetMapping("/users/")
	public List<UserDetailsDto> getrUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<UserDetailsDto> getUser(@PathVariable long id) {
		return userRepo.findById(id);
	}

}
