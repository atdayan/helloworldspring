package com.atdayan.helloworld.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atdayan.helloworld.services.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value="name", required=false) String name) {
		return String.format("Hello %s!", helloService.greetings(name));
	}
	
	@Controller
	public class HelloControllerRender {
		@GetMapping("/greet")
		public String hello(@RequestParam(value="name", required=false) String name, Model model) {
			model.addAttribute("greeting", helloService.greetings(name));
			return "hello";
		}
	} 
}
