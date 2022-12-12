package com.example.websocket.controller;

import com.example.websocket.domain.Greeting;
import com.example.websocket.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


  @MessageMapping("/hello") //  When a message is sent to the /hello destination, the greeting() method is called
  @SendTo("/topic/greetings") // The return value is broadcast to all subscribers of /topic/greetings
  public Greeting greeting(final HelloMessage helloMessage) throws InterruptedException {
    Thread.sleep(2000L);
    return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName()));
  }
}
