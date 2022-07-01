package com.example.demo1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo1.DAO.UserDAO;
import com.example.demo1.model.User;

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
    public ModelAndView userRegistration(@RequestParam(value = "username",required = false) String username, @RequestParam(value = "password", required = false) String password) {

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
            mv.setViewName("register");//跳转的view
        }

        

        return mv;

    }

}
