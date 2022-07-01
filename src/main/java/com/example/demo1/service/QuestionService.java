package com.example.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DAO.QuestionDAO;
import com.example.demo1.model.Question;

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
