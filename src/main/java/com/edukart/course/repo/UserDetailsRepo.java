package com.edukart.course.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edukart.course.entity.UserDetailsDto;

public interface UserDetailsRepo extends MongoRepository<UserDetailsDto,Long> {

}
