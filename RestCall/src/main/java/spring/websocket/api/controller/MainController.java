package spring.websocket.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.websocket.api.entities.Student;

@RestController
public class MainController {
	@Autowired
	Student student;
	@GetMapping("/get")
	public Student getStudentData() {
		return student;
		
	}
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return student;
	}
      
}
