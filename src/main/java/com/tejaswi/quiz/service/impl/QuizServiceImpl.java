package com.tejaswi.quiz.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejaswi.quiz.entity.Category;
import com.tejaswi.quiz.entity.Quiz;
import com.tejaswi.quiz.repo.QuizRepo;
import com.tejaswi.quiz.service.QuizService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {
		// TODO Auto-generated method stub
		// System.out.println(this.quizRepo.findAll());
		return new HashSet<Quiz>(this.quizRepo.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return this.quizRepo.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		this.quizRepo.deleteById(quizId);
		;
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizRepo.findBycategory(category);
	}

	public List<Quiz> getActiveQuizzes() {
		return this.quizRepo.findByActiveStatus(true);
	}

	public List<Quiz> getActiveListQuizzesAndStatus(Category cat) {
		return this.quizRepo.findByCategoryAndActiveStatus(cat, true);
	}
}
