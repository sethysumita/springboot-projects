package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/source")
	public String source() {
		return "source";
	}
	
	@GetMapping("/destination")
	public String destination() {
		return "destination";
	}

}
