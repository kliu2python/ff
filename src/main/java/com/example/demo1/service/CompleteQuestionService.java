package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DAO.CompleteQuestionDAO;
import com.example.demo1.model.CompleteQuestion;

@Service
public class CompleteQuestionService {
	
	@Autowired
	private CompleteQuestionDAO completeQuestionDao;
	
	public void saveToDB(int qid, int completeQuizId, String chosenOption, boolean isCorrect) {
		this.completeQuestionDao.saveToTable(qid, completeQuizId, chosenOption, isCorrect);
	}
	
	public CompleteQuestion reportToUser(int questionId, int quizId) {
		return this.completeQuestionDao.reportForUser(questionId, quizId);
	}
	
	public List<Integer> getQuestionsId(int quizId) {
		return this.completeQuestionDao.getQuestionsId(quizId);
	}
}
