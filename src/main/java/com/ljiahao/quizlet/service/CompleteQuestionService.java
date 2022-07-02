package com.ljiahao.quizlet.service;

import java.util.List;

import com.ljiahao.quizlet.DAO.CompleteQuestionDAO;
import com.ljiahao.quizlet.model.CompleteQuestion;
import com.ljiahao.quizlet.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<CompleteQuestion> getAllQuestionDoneOnQuiz(int quizId) {
		return this.completeQuestionDao.getAllQuestionsDoneOnQuiz(quizId);
	}
}
