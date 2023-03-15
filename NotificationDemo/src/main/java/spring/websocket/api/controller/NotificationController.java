package spring.websocket.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import spring.websocket.api.entity.Notification;
import spring.websocket.api.repo.NotificationRepo;



@Controller
public class NotificationController {
	
	@Autowired
	NotificationRepo notificationRepo;
	
	@GetMapping("/get")
	public String getPage(Model model) {
		model.addAttribute("notify", new Notification());
		return "input";
		
	}
	@PostMapping("/save")
	public String savePage(@ModelAttribute Notification notification, Model model) {
		Notification saved= notificationRepo.save(notification);
		model.addAttribute("saved", saved);
		return "redirect:/get";
		
	}

}
