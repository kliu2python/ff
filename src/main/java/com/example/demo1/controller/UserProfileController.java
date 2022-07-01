package com.example.demo1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.model.CompleteQuestion;
import com.example.demo1.model.CompleteQuiz;
import com.example.demo1.model.Question;
import com.example.demo1.model.Quiz;
import com.example.demo1.model.User;
import com.example.demo1.service.CompleteQuestionService;
import com.example.demo1.service.CompleteQuizService;
import com.example.demo1.service.QuestionService;

@Controller
public class UserProfileController {
	
	@Autowired
	private CompleteQuizService completeQuizService;
	@Autowired
	private CompleteQuestionService completeQuestionService;
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	public ModelAndView userProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
	    if (user == null) {
	    	return new ModelAndView("redirect:/login");
	    }
	    int uid = user.getUserId();
		List<CompleteQuiz> allQuiz = completeQuizService.getQuizDone(uid);
		mv.addObject("allQuiz", allQuiz);
	    mv.addObject("profiles", user);
	    mv.setViewName("profile");
	    return mv;
	}
	
	@RequestMapping(value="/profile/report", method = RequestMethod.GET)
	public ModelAndView  CompletedQuestionReport(@RequestParam(required = true)int quizId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Map<Integer, Map<String, Object>> reportMap = new HashMap<>();
		
		User user = (User) session.getAttribute("user");
	    if (user == null) {
	    	return new ModelAndView("redirect:/login");
	    }
	    
		List<Integer> qIds = completeQuestionService.getQuestionsId(quizId);
		
		for (int theId : qIds) {
			Map<String, Object> questionList = new HashMap<>();
	    	CompleteQuestion cq = completeQuestionService.reportToUser(questionService.getQuestion(theId).getId(), quizId);
	    	Question q = questionService.getQuestion(theId);
	    	questionList.put("question_template", q);
	    	questionList.put("completed_question", cq);
	    	reportMap.put(theId, questionList);
		}
		mv.addObject("quizId", qIds);
		mv.addObject("questions", reportMap);
		mv.setViewName("completedQuiz");
		return mv;
	}
}
