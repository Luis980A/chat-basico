package com.umg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.umg.handler.ChatWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebsocketConfiguration implements WebSocketConfigurer{
	
	private final static String CHAT_ENPOINT = "/chat";

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addHandler(getChatWebSocketHandler(), CHAT_ENPOINT)
		.setAllowedOrigins("*");
	}
	
	@Bean
	public WebSocketHandler getChatWebSocketHandler() {
		return new ChatWebSocketHandler();
	}
}
