package com.edukart.course.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edukart.models.Order;


public interface OrderRepository extends MongoRepository<Order, String> {

	List<Order> findByStatus(String status);

	List<Order> findByUserId(String userId);
	
	List<Order> findByUserIdAndStatus(String userId,String status);
 
}
