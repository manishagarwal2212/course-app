package com.edukart.course.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edukart.course.repo.OrderRepository;
import com.edukart.models.Order;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	  @Autowired
	  OrderRepository orderRepository;

	  @GetMapping("/orders")
	  public ResponseEntity<List<Order>> getAllOrders(@RequestParam(required = false) String status) {
		  try {
		    List<Order> orders = new ArrayList<Order>();

		    if (status == null)
		      orderRepository.findAll().forEach(orders::add);
		    else
		      orderRepository.findByStatus(status).forEach(orders::add);

		    if (orders.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(orders, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }
	  
	  @GetMapping("/orders/{userId}")
	  public ResponseEntity<List<Order>> getAllOrdersByUser(@PathVariable("userId") String userId,
			  @RequestParam(required = false) String status) {
		  try {
		    List<Order> orders = new ArrayList<Order>();

		    if (status == null)
		      orderRepository.findByUserId(userId).forEach(orders::add);
		    else
		      orderRepository.findByUserIdAndStatus(userId,status).forEach(orders::add);

		    if (orders.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(orders, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }

	  @GetMapping("/orders/{id}")
	  public ResponseEntity<Order> getOrderById(@PathVariable("id") String id) {
		  Optional<Order> orderData = orderRepository.findById(id);

		  if (orderData.isPresent()) {
		    return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @PostMapping("/orders")
	  public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		  try {
			    Order _order = orderRepository.save(order);
			    return new ResponseEntity<>(_order, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @PutMapping("/orders/{id}")
	  public ResponseEntity<Order> updateOrder(@PathVariable("id") String id, @RequestBody Order order) {
		  Optional<Order> orderData = orderRepository.findById(id);

		  if (orderData.isPresent()) {
		    Order _order = orderData.get();
		    _order.setStatus(order.getStatus());
		    _order.setShippingCharge(order.getShippingCharge());
		    _order.setOrderTotal(order.getOrderTotal());
		    _order.setProductQuantityMap(order.getProductQuantityMap());
		    return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @DeleteMapping("/orders/{id}")
	  public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") String id) {
		  try {
			    orderRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @DeleteMapping("/orders")
	  public ResponseEntity<HttpStatus> deleteAllOrders() {
		  try {
			    orderRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
}
