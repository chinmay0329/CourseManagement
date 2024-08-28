package com.in28minutes.springboot.mysecondwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

//import com.in28minutes.spring.boot.myfirstwebapp.todo.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService 
{

	private static List<Todo> todos = new ArrayList<>();
	private static int count=0;
	static {
		todos.add(new Todo(++count, "Chinmay", "Learn Spring", LocalDate.now().plusYears(1),false
				));
		todos.add(new Todo(++count, "Chinmay", "Learn AWS", LocalDate.now().plusYears(2),false
				));
		todos.add(new Todo(++count, "Chinmay", "Learn Cloud09", LocalDate.now().plusYears(3),false
				));
		todos.add(new Todo(++count, "Ranga", "Learn Cloud12", LocalDate.now().plusYears(3),false
				));
		}
	
	public List<Todo> findByUsername(String username)
	{
		List<Todo> todosTemp=new ArrayList<Todo>();
		for(int i=0;i<todos.size();i++)
		{
			if(todos.get(i).getUsername().equals(username))
				todosTemp.add(todos.get(i));
		}
		return todosTemp;
//		List<Todo> todosTemp=todos.stream().filter(e-> e.getUsername().equals(username))
//							.collect(Collectors.toList());
//		 return todosTemp;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done)
	{
		Todo todo=new Todo(++count, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id)
	{
		for(int i=0;i<todos.size();i++)
		{
			if(todos.get(i).getId()==id)
				todos.remove(i);
		}
	}
	
	public Todo findById(int id)
	{
		int i=0;
		for(i=0;i<todos.size();i++)
		{
			if(todos.get(i).getId()==id)
				break;
		}
		return todos.get(i);
	}
	
	public void updateTodo1(int id, String description)
	{
		int i=0;
		for(i=0;i<todos.size();i++)
		{
			if(todos.get(i).getId()==id)
			{
				todos.get(i).setDescription(description);
//				todos.get(i).setDone(todo.isDone());
//				todos.get(i).setTargetDate(todo.getTargetDate());
			}
		}
	}
	
	public void updateTodo(@Valid Todo todo)
	{
		deleteById(todo.getId());
		todos.add(todo);
	}
}
