package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Employee;

@Controller
public class SendMessageController {
	private final SimpMessagingTemplate template;
	
	public SendMessageController(SimpMessagingTemplate template) {
		this.template = template;
	}
	
	@GetMapping("/fill")
	public String sendData(Model model) {
		model.addAttribute("sent", new Employee());
		return "emp";
		
	}
  
  @MessageMapping("/sendMessage")
  public void sendText( Employee emp) throws Exception {
	  System.out.println(emp.getContent());
	  template.convertAndSend("/topic/details/"+emp.getReceiverId(), emp);
  }
//  @MessageMapping("/saveEmp")
//  @SendTo("/topic/info")
//  public Employee saveEmp(Employee emp) {
//	return emp;
//	  
//  }
}
