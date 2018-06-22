package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.bean.User;
import com.training.dao.UserDAO;

@Controller
public class LoginController {
	
	@Autowired
	UserDAO user;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String getLoginPage(){
		return "home";
	}
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ModelAndView processLogin(@RequestParam("username") String username, 
			@RequestParam("password") String password){
		
		ModelAndView mv= new ModelAndView();
		User loginUser = new User(username,password);
		if(user.login(loginUser) != null){
			mv.setViewName("success");
			mv.addObject("username",username);
		}else{
			mv.setViewName("failure");
		}
		
		return mv;
		
	}
	

	
}
