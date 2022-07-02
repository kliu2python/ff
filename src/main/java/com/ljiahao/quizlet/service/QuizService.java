package com.ljiahao.quizlet.service;

import java.util.List;

import com.ljiahao.quizlet.DAO.QuizDAO;
import com.ljiahao.quizlet.model.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

	@Autowired
	private QuizDAO quizDao;

	public List<Quiz> getQuiz() {
		List<Quiz> res = this.quizDao.getQuiz();
		return res;
	}
}
