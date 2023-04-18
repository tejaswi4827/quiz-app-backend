package com.tejaswi.quiz.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@Table(name = "question_list")
@NoArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	@Column(length = 5000)
	private String content;
	private String image;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quizes;
}
