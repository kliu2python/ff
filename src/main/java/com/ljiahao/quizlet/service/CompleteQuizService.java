package com.ljiahao.quizlet.service;

import java.util.List;

import com.ljiahao.quizlet.DAO.CompleteQuizDAO;
import com.ljiahao.quizlet.model.CompleteQuiz;
import com.ljiahao.quizlet.model.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompleteQuizService {
	@Autowired
	private CompleteQuizDAO completeQuizDao;

	public List<CompleteQuiz> getQuizDone(int uid) {
		return this.completeQuizDao.getQuizDone(uid);
	}

	public void Save(int uid, int qid, String sDate, String fDate, int score) {
		this.completeQuizDao.saveToTable(uid, qid, sDate, fDate, score);
	}

	public int getMaxId() {
		return this.completeQuizDao.getMaxId();
	}
}
