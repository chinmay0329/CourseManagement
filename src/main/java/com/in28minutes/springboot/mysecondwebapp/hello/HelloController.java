package com.in28minutes.springboot.mysecondwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController 
{
	@RequestMapping("say-hello-sir")
//	@ResponseBody
	public String helloSir()
	{
		return "sayHello";
	}
}
