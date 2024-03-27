package com.atdayan.helloworld.services;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public String greetings(String name) {
		if (name == null || name.equals(""))
			return "there";
		return name;
	}
}
