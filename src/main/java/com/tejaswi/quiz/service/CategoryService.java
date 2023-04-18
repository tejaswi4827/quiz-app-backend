package com.tejaswi.quiz.service;

import java.util.Set;

import com.tejaswi.quiz.entity.Category;



public interface CategoryService {

	public Category addCategory(Category category);

	public Category updateCategory(Category category);

	public Set<Category> getCategories();

	public Category getCategoryById(Long categoryId);

	public void deleteCategory(Long categoryId);

}
