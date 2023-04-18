package com.tejaswi.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejaswi.quiz.entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

}
