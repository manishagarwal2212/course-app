package com.edukart.models;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
  
	  @Id
	  private String id;
	
	  private String userId;
	  private String status;
	  private Map<String,Integer> productQuantityMap;
	  private double shippingCharge;
	  private double orderTotal;

	  public String getId() {
		return id;
	  }
	  
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, Integer> getProductQuantityMap() {
		return productQuantityMap;
	}
	public void setProductQuantityMap(Map<String, Integer> productQuantityMap) {
		this.productQuantityMap = productQuantityMap;
	}
	public double getShippingCharge() {
		return shippingCharge;
	}
	public void setShippingCharge(double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	 
}
