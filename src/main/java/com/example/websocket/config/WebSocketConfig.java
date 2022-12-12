package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    // enable a simple memory-based message broker to carry the greeting messages back to the client on destinations prefixed with /topic
    registry.enableSimpleBroker("/topic");

    // prefix for messages that are bound for methods annotated with @MessageMapping
    registry.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    // registers the /gs-websocket endpoint, enabling SockJS fallback options so that alternate transports can be used if WebSocket is not available
    registry.addEndpoint("gs-websocket").withSockJS();
  }
}
