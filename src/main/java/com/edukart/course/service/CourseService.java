package com.edukart.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edukart.course.entity.CourseDto;
import com.edukart.course.repo.CourseRepo;



@Component
public class CourseService {
	
	@Autowired 
	CourseRepo repository;
	
    public void add(CourseDto dto) {
        repository.save(dto);
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<CourseDto> getCourses() {
        return (List<CourseDto>) repository.findAll();
    }
    public CourseDto getCourseById(long id) {
        Optional<CourseDto> optionalCourse = repository.findById(id);
        return optionalCourse.get();
    }
    
}
