package com.edukart.course.entity;



//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;


//@Entity
public class CourseDto {
	
//	@Id
//    @GeneratedValue
	private long id;
	private String title;
	private long categoryId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
}
