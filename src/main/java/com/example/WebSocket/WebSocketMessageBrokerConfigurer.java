package com.example.WebSocket;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

public interface WebSocketMessageBrokerConfigurer {
    void configureMessageBroker(MessageBrokerRegistry config);

    void registerStompEndpoints(StompEndpointRegistry registry);
}
