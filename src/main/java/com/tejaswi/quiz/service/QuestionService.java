package com.tejaswi.quiz.service;

import java.util.Set;

import com.tejaswi.quiz.entity.Question;
import com.tejaswi.quiz.entity.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);

	public Question updateQuestion(Question question);

	public Set<Question> getQuestions();

	public Question getQuestionById(Long questionId);

	public Set<Question> getQuestionsOfQuiz(Quiz quiz);

	public void deleteQuestion(Long questionId);

	public Question get(Long questionId);
}