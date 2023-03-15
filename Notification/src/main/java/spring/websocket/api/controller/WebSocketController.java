package spring.websocket.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSocketController {
	 @Autowired
	    SimpMessagingTemplate simpMessagingTemplate;

	    @MessageMapping("/application")
	    @SendTo("/all/messages")
	    public Message send(final Message message) throws Exception {
	        return message;
	    }
     @GetMapping("/page") 
     public String getPage() {
		return "text";
    	 
     }
}
