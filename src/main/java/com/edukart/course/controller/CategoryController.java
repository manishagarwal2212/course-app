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

import com.edukart.course.repo.CategoryRepository;
import com.edukart.models.Category;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	  @Autowired
	  CategoryRepository categoryRepository;

	  @GetMapping("/categories")
	  public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name) {
		  try {
		    List<Category> categorys = new ArrayList<Category>();

		    if (name == null)
		      categoryRepository.findAll().forEach(categorys::add);
		    else
		      categoryRepository.findByNameContaining(name).forEach(categorys::add);

		    if (categorys.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }

		    return new ResponseEntity<>(categorys, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }

	  @GetMapping("/categories/{id}")
	  public ResponseEntity<Category> getCategoryById(@PathVariable("id") String id) {
		  Optional<Category> categoryData = categoryRepository.findById(id);

		  if (categoryData.isPresent()) {
		    return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @PostMapping("/categories")
	  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		  try {
			    Category _category = categoryRepository.save(category);
			    return new ResponseEntity<>(_category, HttpStatus.CREATED);
			  } catch (Exception e) {
			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @PutMapping("/categories/{id}")
	  public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, @RequestBody Category category) {
		  Optional<Category> categoryData = categoryRepository.findById(id);

		  if (categoryData.isPresent()) {
		    Category _category = categoryData.get();
		    _category.setName(category.getName());
		    _category.setDescription(category.getDescription());
		    return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	  }

	  @DeleteMapping("/categories/{id}")
	  public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") String id) {
		  try {
			    categoryRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }

	  @DeleteMapping("/categorys")
	  public ResponseEntity<HttpStatus> deleteAllCategorys() {
		  try {
			    categoryRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }


}
