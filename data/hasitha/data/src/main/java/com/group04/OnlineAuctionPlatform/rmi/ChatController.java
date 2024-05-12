package com.group04.OnlineAuctionPlatform.rmi;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ChatController {

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        return "Received: " + message;
    }
}
