package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	//all can access this url
	@GetMapping("/hello")
	public String all() {
		return "hello centroxy";
	}
	
	//user & admin can access this url
	@GetMapping("/user")
	public String user() {
		return "hello user";
	}
	
 //admin can access to both user
	@GetMapping("/admin")
	public String admin() {
		return "hello people";
		
	}
}
