package com.tejaswi.quiz.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quizId;
	private String quizTitle;
	private String description;
	private String maxMarks;
	private String numberOfQuestion;
	private boolean activeStatus = false;
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "quizes",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Question>questions = new HashSet<>();
	
}
