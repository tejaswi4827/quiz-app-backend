package com.tejaswi.quiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejaswi.quiz.entity.Category;
import com.tejaswi.quiz.entity.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

	public List<Quiz> findBycategory(Category category);

	public List<Quiz> findByActiveStatus(Boolean bool);

	public List<Quiz> findByCategoryAndActiveStatus(Category category, boolean bool);
}
