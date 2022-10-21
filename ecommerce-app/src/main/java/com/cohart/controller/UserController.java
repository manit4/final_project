package com.cohart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String username, String password, String firstName, String lastName, String email) {
		System.out.println("inside register method.."+username+", "+password);
		return "index";
	}

}
