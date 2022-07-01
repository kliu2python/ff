package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DAO.CompleteQuizDAO;
import com.example.demo1.model.CompleteQuiz;
import com.example.demo1.model.Quiz;

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
}
