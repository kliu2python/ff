package com.ljiahao.quizlet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "completed_question")
public class CompleteQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "question_id")
	int questionId;
	@Column(name = "completed_quiz_id")
	int completedQuizId;
	@Column(name = "chosen_option")
	String chosenOption;
	@Column(name = "is_correct")
	boolean isCorrect;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getCompletedQuizId() {
		return completedQuizId;
	}

	public void setCompletedQuizId(int completedQuizId) {
		this.completedQuizId = completedQuizId;
	}

	public String getChosenOption() {
		return chosenOption;
	}

	public void setChosenOption(String chosenOption) {
		this.chosenOption = chosenOption;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
