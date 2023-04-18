package com.tejaswi.quiz.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejaswi.quiz.entity.Question;
import com.tejaswi.quiz.entity.Quiz;
import com.tejaswi.quiz.repo.QuestionRepo;
import com.tejaswi.quiz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.questionRepo.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.questionRepo.findAll());
	}

	@Override
	public Question getQuestionById(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepo.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.questionRepo.findByQuizes(quiz);
	}

	@Override
	public void deleteQuestion(Long questionId) {
		// TODO Auto-generated method stub
		// this.questionRepo.deleteById(questionId);
		this.questionRepo.deleteByQuestionId(questionId);
	}

	@Override
	public Question get(Long questionId) {
		// TODO Auto-generated method stub

		return this.questionRepo.getOne(questionId);
	
	}

}
