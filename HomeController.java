package com.niit.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.collabration2.dao.UserDAO;
import com.niit.collabration2.model.User;

@Controller
public class HomeController {
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	User a;
	
	
	

	@RequestMapping("/")
	public ModelAndView showIndex() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "thank for visit");
		return mv;
		
	}
	
	@RequestMapping("/next")
	public ModelAndView next() {
		ModelAndView mv = new ModelAndView("next");
		System.out.println("in next ");
		a.setUserid(1);
		a.setUsername("harsha");
		a.setPassword("jvs");
		a.setEmail("jvsharsha333@gmail.com");
		//a.setCreationdate(save Date());
		a.setContact(9666472);
		userDAO.save(a);
		System.out.println("completed");
		return mv;
	}

	
}

