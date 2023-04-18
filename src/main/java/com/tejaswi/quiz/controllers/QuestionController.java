package com.tejaswi.quiz.controllers;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

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

import com.tejaswi.quiz.entity.Question;
import com.tejaswi.quiz.entity.Quiz;
import com.tejaswi.quiz.payloads.ApiResponse;
import com.tejaswi.quiz.service.QuestionService;
import com.tejaswi.quiz.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {

		Question question2 = this.questionService.addQuestion(question);
		return new ResponseEntity<Question>(question2, HttpStatus.CREATED);
	}

	@PutMapping("/updateQuestion")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {

		Question question2 = this.questionService.updateQuestion(question);
		return new ResponseEntity<Question>(question2, HttpStatus.OK);
	}

	@GetMapping("/getAllQuestions")
	public ResponseEntity<?> getQuestions() {

		return ResponseEntity.ok(this.questionService.getQuestions());
	}

	@GetMapping("/{quesId}")
	public ResponseEntity<?> getQuestionById(@PathVariable Long quesId) {
		return ResponseEntity.ok(this.questionService.getQuestionById(quesId));
	}

	@DeleteMapping("/{quesId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long quesId) {
		try {
			this.questionService.deleteQuestion(quesId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Question deleted successfully"), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<ApiResponse>(new ApiResponse("Question not deleted !!!"), HttpStatus.BAD_REQUEST);
		}
	}

	// evaluate quiz marks
	@PostMapping("/eval")
	ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> ques) {
		int totalMarksObtained = 0;
		int correctAnswer = 0;
		int attempted = 0;
		System.out.println(ques);
		for (Question q : ques) {
			Question question = this.questionService.get(q.getQuestionId());
			if (question.getAnswer().equals(q.getAnswer())) {
				correctAnswer++;
			}
			if (q.getAnswer() == null || q.getAnswer().equals("")) {
				attempted++;
			}
		}
		int maxMarks = Integer.parseInt(ques.get(0).getQuizes().getMaxMarks());
		int noOfQuestion = Integer.parseInt(ques.get(0).getQuizes().getNumberOfQuestion());
		totalMarksObtained = (maxMarks / noOfQuestion) * correctAnswer;
		double marksPercentage = (totalMarksObtained * 100) / maxMarks;
		DecimalFormat f = new DecimalFormat("##.00");
		LinkedHashMap<String, Object> map = new LinkedHashMap<>();
		map.put("Marks_Obtained", totalMarksObtained);
		map.put("Total_correct_answer", correctAnswer);
		map.put("Marks_Percentage", f.format(marksPercentage));

		return ResponseEntity.ok(map);
	}

	// get all question of quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable Long quizId) {
//		Quiz quiz = new Quiz();
//		quiz.setQuizId(quizId);
//		Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//		return ResponseEntity.ok(questionOfQuiz);
		try {
			Quiz quiz = this.quizService.getQuiz(quizId);

			// getting all question of quiz from question table and quiz id is foreign key
			// of question table
			Set<Question> questions = this.questionService.getQuestionsOfQuiz(quiz);
			// System.out.println(questions.size());
			String sizeOfQuestion = quiz.getNumberOfQuestion();
			// System.out.println(sizeOfQuestion);
			// setting answer to null so answer will not go to ui along with payload
			for (Question ques : questions) {
				ques.setAnswer(null);
			}
			List list = new ArrayList<>(questions);

			if (Integer.parseInt(sizeOfQuestion) < questions.size()) {
				list = list.subList(0, Integer.parseInt(sizeOfQuestion));
			}
			java.util.Collections.shuffle(list);
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<ApiResponse>(new ApiResponse("Item not found in database !!!"),
					HttpStatus.BAD_REQUEST);

		}

		// calculate quiz marks

	}

}
