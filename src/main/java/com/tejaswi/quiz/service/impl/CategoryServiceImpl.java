package com.tejaswi.quiz.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejaswi.quiz.entity.Category;
import com.tejaswi.quiz.repo.CategoryRepo;
import com.tejaswi.quiz.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub

		return new HashSet<Category>(this.categoryRepo.findAll());
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepo.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		
		this.categoryRepo.deleteById(categoryId);
		
	}

}
