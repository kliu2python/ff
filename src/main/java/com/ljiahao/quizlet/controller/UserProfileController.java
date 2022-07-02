package com.ljiahao.quizlet.controller;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProfileController {

	@Autowired
	private CompleteQuizService completeQuizService;
	@Autowired
	private CompleteQuestionService completeQuestionService;
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
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

	@RequestMapping(value = "/profile/report", method = RequestMethod.GET)
	public ModelAndView CompletedQuestionReport(@RequestParam(required = true) int quizId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Map<Integer, Map<String, Object>> reportMap = new HashMap<>();
		List<Integer> qIds = new ArrayList<>();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}

		List<CompleteQuestion> cqs = completeQuestionService.getAllQuestionDoneOnQuiz(quizId);
		for (CompleteQuestion cq : cqs) {
			qIds.add(cq.getQuestionId());
		}
		for (int theId : qIds) {
			Map<String, Object> questionList = new HashMap<>();
			CompleteQuestion cq = completeQuestionService.reportToUser(questionService.getQuestion(theId).getId(),
					quizId);
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
