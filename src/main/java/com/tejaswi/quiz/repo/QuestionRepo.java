package com.tejaswi.quiz.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tejaswi.quiz.entity.Question;
import com.tejaswi.quiz.entity.Quiz;
@Repository
public interface QuestionRepo extends JpaRepository<Question,Long >{
	Set<Question> findByQuizes(Quiz quiz);

	  void deleteByQuestionId(Long qId);
}
