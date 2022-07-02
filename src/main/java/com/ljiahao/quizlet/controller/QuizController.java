package com.ljiahao.quizlet.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ljiahao.quizlet.model.CompleteQuestion;
import com.ljiahao.quizlet.model.CompleteQuiz;
import com.ljiahao.quizlet.model.Question;
import com.ljiahao.quizlet.model.Quiz;
import com.ljiahao.quizlet.model.User;
import com.ljiahao.quizlet.service.CompleteQuestionService;
import com.ljiahao.quizlet.service.CompleteQuizService;
import com.ljiahao.quizlet.service.QuestionService;
import com.ljiahao.quizlet.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private CompleteQuizService completeQuizService;
	@Autowired
	private CompleteQuestionService completeQuestionService;

	@RequestMapping(value = "/quiz", method = RequestMethod.GET)
	public ModelAndView quizList(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}
		List<Quiz> qs = quizService.getQuiz();
		mv.addObject("quizes", qs);
		mv.addObject("userId", user.getUserId());
		mv.setViewName("quiz");
		return mv;
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView completedQuizDetail(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		Map<Question, CompleteQuestion> questionMap = new HashMap<>();
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}
		int maxId = completeQuizService.getMaxId();
		List<CompleteQuestion> cqs = completeQuestionService.getAllQuestionDoneOnQuiz(maxId);
		for (CompleteQuestion cq : cqs) {
			questionMap.put(questionService.getQuestion(cq.getQuestionId()), cq);
		}
		mv.addObject("result", questionMap);
		mv.setViewName("result");
		return mv;
	}
}
