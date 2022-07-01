package com.example.demo1.controller;

import com.example.demo1.DAO.UserDAO;
import com.example.demo1.model.Question;
import com.example.demo1.model.Quiz;
import com.example.demo1.model.User;
import com.example.demo1.service.QuizService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {
    @Autowired
    private UserDAO userDAO;
    
    @GetMapping("/")
    public ModelAndView index(HttpSession session) {
    	ModelAndView mv = new ModelAndView();
    	User user = (User) session.getAttribute("user");
	    if (user != null) {
	    	return new ModelAndView("redirect:/quiz");
	    }
	    
	    mv.setViewName("welcome");
    	return mv;
    }
    
    @GetMapping("/login")
    public ModelAndView userLogin(HttpSession session) {
    	ModelAndView mv = new ModelAndView();
    	User user = (User) session.getAttribute("user");
	    if (user != null) {
	    	return new ModelAndView("redirect:/quiz");
	    }
    	mv.setViewName("login");
    	return mv;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam String username ,  @RequestParam String password, HttpSession session) {

        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String name = userDAO.loginUser(user);
        user.setUserId(Integer.parseInt(name));
        if (name != null) {
        	session.setAttribute("user", user);
            return new ModelAndView("redirect:/quiz");
        } else {
            mv.addObject("msg", "Invalid user id or password.");
            mv.setViewName("login");
            return mv;
        }
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView userLogout(HttpSession session) {
    	session.removeAttribute("user");
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("msg", "Bye-bye, welcome back to use QuizLet");
    	mv.setViewName("byebye");
    	return mv;
    }
}
