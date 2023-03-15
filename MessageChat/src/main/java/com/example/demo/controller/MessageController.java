package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Chat;

@Controller
public class MessageController {
	
	private final SimpMessagingTemplate template;

	public MessageController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@GetMapping("/send")
	public String sendMessage(Model model) {
		model.addAttribute("sent", new Chat());
		return "text";
		
	}
  @GetMapping("/recieve")
  public String recieveMessage() { 
	return "show";
	  
  }
  @MessageMapping("/textTo")
  public void textSomeOne(Chat chatShow)throws Exception{
	  template.convertAndSend("/message/greetings", chatShow);
	
	  
  }
  
  
//  @MessageMapping("/textTo/{id}")
//  public void textSomeOne(@DestinationVariable int ChatId) {
//	  Chat chat = chatRepository.findByid(ChatId);
//	  Chat savedChat = chatRepository.save(chat);
//	  template.convertAndSend("/message/greetings", savedChat);
//	  
//  }
}
