package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	// Can be accessed by any user
	@GetMapping("/hello")
	public String home() {
		return "Hello world";
	}
	
	
	//can be accessed by only authenticated users with admin or user role
	@GetMapping("/user")
	public String user() {
		return "Hello User";
	}
	
	
	//Can be accessed by only admin role
	@GetMapping("/admin")
	public String admin() {
		return "Hello Admin";
	}
	
	

}
