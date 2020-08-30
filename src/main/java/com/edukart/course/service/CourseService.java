package com.edukart.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edukart.course.entity.Course;
import com.edukart.course.repo.CourseRepo;



@Component
public class CourseService {
	
	@Autowired 
	CourseRepo repository;
	
    public void add(Course dto) {
        repository.save(dto);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Course> getCourses() {
        return (List<Course>) repository.findAll();
    }
    public Course getCourseById(long id) {
        Optional<Course> optionalCourse = repository.findById(id);
        return optionalCourse.get();
    }
    
}
