package com.ljiahao.quizlet.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ljiahao.quizlet.model.CompleteQuestion;
import com.ljiahao.quizlet.model.CompleteQuiz;
import com.ljiahao.quizlet.model.Question;
import com.ljiahao.quizlet.model.Quiz;
import com.ljiahao.quizlet.model.User;
import com.ljiahao.quizlet.service.CompleteQuestionService;
import com.ljiahao.quizlet.service.CompleteQuizService;
import com.ljiahao.quizlet.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private CompleteQuestionService completeQuestionService;
	@Autowired
	private CompleteQuizService completeQuizService;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@GetMapping("/list")
	public ModelAndView listQuestions(@RequestParam(required = true) int theId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}
		List<Question> aq = questionService.getAllQuizs(theId);

		Date date = new Date();
		completeQuizService.Save(user.getUserId(), 3, formatter.format(date), formatter.format(date), 0);
		mv.addObject("questions", aq);
		mv.setViewName("questions");
		return mv;
	}

	@RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
	public void saveOrUpdate(@RequestBody(required = true) CompleteQuestion cq, HttpSession session) {
		Question q = questionService.getQuestion(cq.getQuestionId());
		int maxId = completeQuizService.getMaxId();
		boolean isCorrect = false;
		if (q.getCorrectAns().equals(cq.getChosenOption()))
			isCorrect = true;
		int qId = cq.getQuestionId();
		String chosenOption = cq.getChosenOption();
		completeQuestionService.saveToDB(qId, maxId, chosenOption, isCorrect);
	}
}
