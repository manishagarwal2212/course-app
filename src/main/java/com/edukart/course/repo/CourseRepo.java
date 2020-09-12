package com.edukart.course.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edukart.course.entity.CourseDto;

@Repository
public interface CourseRepo extends CrudRepository<CourseDto, Long>{

}

