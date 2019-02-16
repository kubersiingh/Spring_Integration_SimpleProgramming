package com.springboot.example.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGatway {
	
	@Gateway(requestChannel = "integration.gateway.channel")
	public String sendMessage(String message);

}
