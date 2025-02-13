package com.in28minutes.springboot.mysecondwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController 
{
	@RequestMapping(value="/",method= RequestMethod.GET)
	public String goToLoginPage(ModelMap model)
	{
		model.put("name", getLoggedinUserName());
		return "welcome";
	}
	
	private String getLoggedinUserName() 
	{
		org.springframework.security.core.Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
}
