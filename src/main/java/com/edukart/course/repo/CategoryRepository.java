package com.edukart.course.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edukart.models.Category;


public interface CategoryRepository extends MongoRepository<Category, String> {
  List<Category> findByNameContaining(String name);
}
