package com.example.demo1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quiz_template")
public class Quiz implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "quiz_name")
	private String quizName;
	@Column(name = "type")
	private String quizType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public String getQuizType() {
		return quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
}
