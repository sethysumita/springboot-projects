package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "Accessed by all users";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Accessed by authenticated users and the Admin";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Accessed by admin only";
	}

}
