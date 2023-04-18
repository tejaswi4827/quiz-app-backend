package com.tejaswi.quiz.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tejaswi.quiz.entity.Category;
import com.tejaswi.quiz.payloads.ApiResponse;
import com.tejaswi.quiz.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryContoller {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {

	Category cat =	this.categoryService.addCategory(category);
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long catId ) {
	return	ResponseEntity.ok(this.categoryService.getCategoryById(catId));
		
	}
	@GetMapping("/allCategory")
	public ResponseEntity<?> getCategories () {
	return ResponseEntity.ok(this.categoryService.getCategories());
		
	}
	 
	@PutMapping("/updateCategory")
	public ResponseEntity<?> updateCategory(@RequestBody Category category) {
		return ResponseEntity.ok(this.categoryService.updateCategory(category));
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long catId) {
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully"),HttpStatus.OK);
	}
	
}
