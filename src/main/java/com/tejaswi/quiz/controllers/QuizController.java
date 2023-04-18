package com.tejaswi.quiz.controllers;

import java.util.List;

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
import com.tejaswi.quiz.entity.Quiz;
import com.tejaswi.quiz.payloads.ApiResponse;
import com.tejaswi.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
		Quiz quizesQuiz = this.quizService.addQuiz(quiz);
		return new ResponseEntity<Quiz>(quizesQuiz, HttpStatus.CREATED);

	}

//get quiz of category
	@GetMapping("/category/{cId}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable Long cId) {
		Category category = new Category();
		category.setCategoryId(cId);
		return this.quizService.getQuizzesOfCategory(category);

	}

	@PutMapping("/updateQuiz")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
		Quiz quizesQuiz = this.quizService.updateQuiz(quiz);
		return new ResponseEntity<Quiz>(quizesQuiz, HttpStatus.CREATED);

	}

	@GetMapping("/{qId}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable Long qId) {
		return ResponseEntity.ok(this.quizService.getQuiz(qId));
	}

	@GetMapping("/getAllQuiz")
	public ResponseEntity<?> getQuizes() {
		return ResponseEntity.ok(this.quizService.getQuizes());
	}

	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes() {
		return this.quizService.getActiveQuizzes();
	}

	@GetMapping("/category/active/{cId}")
	public List<Quiz> getActiveQuizzesAndCategory(@PathVariable long cId) {
		Category category = new Category();
		category.setCategoryId(cId);
		return this.quizService.getActiveListQuizzesAndStatus(category);
	}

	@DeleteMapping("/{quizId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Long quizId) {
		try {
			this.quizService.deleteQuiz(quizId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz deleted successfully"), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz deletion failed"), HttpStatus.BAD_REQUEST);
		}

	}
}
