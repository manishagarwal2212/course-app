package com.edukart.course.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edukart.models.Product;



public interface ProductRepository extends MongoRepository<Product, String> {
  List<Product> findByNameContaining(String name);
}
