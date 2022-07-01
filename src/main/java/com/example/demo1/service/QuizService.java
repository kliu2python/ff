package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DAO.QuizDAO;
import com.example.demo1.model.Quiz;

@Service
public class QuizService {
	
	@Autowired
	private QuizDAO quizDao;
	
	
	public List<Quiz> getQuiz() {
		List<Quiz> res = this.quizDao.getQuiz();
		return res;
	}
}
