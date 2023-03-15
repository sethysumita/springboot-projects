package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/hello")
	public String display() {
		return "hello all";
		
	}
    @GetMapping("/user")
    public String user() {
		return "hello users";
    	
    }
    @GetMapping("/admin")
    public String admin() {
		return "hello admin";
    	
    }
}
