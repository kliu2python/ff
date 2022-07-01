package com.example.demo1.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.model.CompleteQuiz;
import com.example.demo1.model.Quiz;
import com.example.demo1.model.User;
import com.example.demo1.service.CompleteQuestionService;
import com.example.demo1.service.CompleteQuizService;
import com.example.demo1.service.QuizService;

@Controller
public class QuizController {
	
	@Autowired
	private QuizService quizService;
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
	    if (user == null) {
	    	return new ModelAndView("redirect:/login");
	    }
	    mv.setViewName("result");
		return mv;
	}
}
