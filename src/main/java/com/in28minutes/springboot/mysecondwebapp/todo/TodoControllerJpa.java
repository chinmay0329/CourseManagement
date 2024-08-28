package com.in28minutes.springboot.mysecondwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa 
{

	@Autowired
	private TodoService service;
	
	@Autowired
	private TodoRepository repository;
	
	@RequestMapping(value="list-todos")
	public String goToTodosPage(ModelMap model)
	{
		String username = getLoggedinUserName(model);
		List<Todo> todos=repository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listtodos";
	}
	
	@RequestMapping(value="add-todo",method= RequestMethod.GET)
	public String addTodoPage(ModelMap model)
	{
//		String username=(String)model.get("name");
		String username = getLoggedinUserName(model);
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	private String getLoggedinUserName(ModelMap model) {
		org.springframework.security.core.Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value="add-todo",method= RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
			return "todo";
		String username = getLoggedinUserName(model);
		todo.setUsername(username);
		repository.save(todo);
//		service.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		repository.deleteById(id);
//		service.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String goToUpdateTodoPage(@RequestParam int id ,ModelMap model)
	{
		Todo todo=repository.findById(id).get();
//		Todo todo=service.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method= RequestMethod.POST)
	public String updateTodo(@RequestParam int id ,ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
			return "todo";
		
		String username = getLoggedinUserName(model);
		
		todo.setUsername(username);
		repository.save(todo);
		
//		todo.setUsername(username);
//		service.updateTodo(todo);
		
//		service.updateTodo1(id,todo.getDescription());
		return "redirect:list-todos";
	}
}