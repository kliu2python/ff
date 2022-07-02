package com.ljiahao.quizlet.controller;

import com.ljiahao.quizlet.DAO.UserDAO;
import com.ljiahao.quizlet.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserRegistratationController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView userRegistration() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView userRegistration(@RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password) {

        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        int counter = userDAO.registerUser(user);

        if (counter > 0) {
            mv.addObject("msg", "User registration successful.");
            mv.setViewName("login");
        } else {
            mv.addObject("msg", "Error- check the console log.");
            mv.setViewName("register");// 跳转的view
        }

        return mv;

    }

}
