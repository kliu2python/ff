package com.ljiahao.quizlet.service;

import java.util.List;

import com.ljiahao.quizlet.DAO.QuestionDAO;
import com.ljiahao.quizlet.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	@Autowired
	private QuestionDAO questionDao;

	public Question getQuestion(int theId) {
		return this.questionDao.findById(theId);
	}

	public List<Question> getAllQuizs(int theType) {
		return this.questionDao.getAllQuizs(theType);
	}
}
