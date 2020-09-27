package com.edukart.course.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edukart.models.UserDetails;

public interface UserDetailsRepo extends MongoRepository<UserDetails,Long> {

}
