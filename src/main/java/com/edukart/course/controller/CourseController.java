package com.edukart.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edukart.course.entity.Course;
import com.edukart.course.service.CourseService;


@RestController
@RequestMapping("courses")
public class CourseController {
	
	@GetMapping("/welcome")
	String hello() {
		return "Welcome to course service";
	}
	
    @Autowired 
    CourseService service;
    
    
    @GetMapping
    public List<Course> getCourses() {
        return service.getCourses();
    }
    
    @PostMapping
    public void postCourses(@RequestBody Course dto) {
        service.add(dto);
    }
    
    @GetMapping("/{id}")
    public Course getById(@PathVariable(required = true) long id) {
        return service.getCourseById(id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }


}