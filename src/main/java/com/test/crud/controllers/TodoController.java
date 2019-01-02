package com.test.crud.controllers;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.crud.models.Todo;
import com.test.crud.repositories.TodoRepository;



@Controller
public class TodoController {
	
	@Autowired
	private TodoRepository todorepo;

	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPage()
	{
		ModelAndView modelview = new ModelAndView();
		Todo todo = new Todo();
		modelview.addObject("todo", todo);
		modelview.setViewName("views/add");
		return modelview;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addTodo(Todo todo, RedirectAttributes redirAttrs)
	{
		ModelAndView modelview = new ModelAndView("redirect:/");
		if(todorepo.save(todo) != null){
			redirAttrs.addFlashAttribute("message", "ToDo added!");
		}
		else{
			redirAttrs.addFlashAttribute("message2", "Something went wrong!");
		}
		
		modelview.addObject("todos",todorepo.findAll());
		
		//modelview.setViewName("/views/home");
		return modelview;
	}
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public ModelAndView detailsPage(@RequestParam Long id)
	{
		ModelAndView modelview = new ModelAndView();
			Todo todo =todorepo.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
			modelview.addObject("task", todo);
//		modelview.addObject("todoName",todo.getName());
//		modelview.addObject("tododuedate",todo.getDuedate());
//		modelview.addObject("tododescription",todo.getDescription());
//		modelview.addObject("todocreatedate",todo.getCreateDateTime());
		modelview.setViewName("views/details");
		return modelview;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editPage(@RequestParam Long editid)
	{
		ModelAndView modelview = new ModelAndView();
		Todo todo =todorepo.findById(editid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + editid));
		modelview.addObject("edittodo", todo);
		System.out.println("HERE IS THE ID--->>>>"+editid);
		modelview.setViewName("views/edit");
		return modelview;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView editTodo(Todo edittodo, RedirectAttributes redirAttrs, HttpServletRequest request)
	{
		ModelAndView modelview = new ModelAndView("redirect:/");
		Todo forUpdateTodo =todorepo.getOne(edittodo.getId());
		forUpdateTodo.setName(edittodo.getName());
		forUpdateTodo.setDuedate(edittodo.getDuedate());
		forUpdateTodo.setDescription(edittodo.getDescription());
		
		if(todorepo.saveAndFlush(forUpdateTodo) != null){
			redirAttrs.addFlashAttribute("message", "ToDo Updated!");
		}
		else{
			redirAttrs.addFlashAttribute("message2", "Something went wrong!");
		}
		
		modelview.addObject("todos",todorepo.findAll());
		
		//modelview.setViewName("/views/home");
		return modelview;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteAction(@RequestParam Long deleteid, RedirectAttributes redirAttrs)
	{
		ModelAndView modelview = new ModelAndView("redirect:/");
		Todo todo =todorepo.findById(deleteid)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + deleteid));
		todorepo.delete(todo);
		redirAttrs.addFlashAttribute("message", "ToDo deleted!");
		System.out.println("DELETE ID--->>>>"+deleteid);
		return modelview;
	}
}
