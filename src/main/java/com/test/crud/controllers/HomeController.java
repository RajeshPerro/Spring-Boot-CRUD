package com.test.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.test.crud.repositories.TodoRepository;


@Controller
public class HomeController {
	
	@Autowired
	private TodoRepository todorepo;
	
	public String jsonData;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView homePage()
	{
		ModelAndView modelview = new ModelAndView();
		//jsonData = new Gson().toJson(todorepo.findAll());
		modelview.addObject("todos",todorepo.findAll());
		modelview.setViewName("views/home");
		return modelview;
	}
}
