package com.tejaswi.quiz.service;

import java.util.List;
import java.util.Set;


import com.tejaswi.quiz.entity.Category;
import com.tejaswi.quiz.entity.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuiz(Quiz quiz);

	public Set<Quiz> getQuizes();

	public Quiz getQuiz(Long quizId);

	public void deleteQuiz(Long quizId);

	public List<Quiz> getQuizzesOfCategory(Category category);

	public List<Quiz> getActiveQuizzes();

	public List<Quiz> getActiveListQuizzesAndStatus(Category category);
}
