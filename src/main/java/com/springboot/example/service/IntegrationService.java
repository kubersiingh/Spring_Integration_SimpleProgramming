package com.springboot.example.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class IntegrationService {
	
	@ServiceActivator(inputChannel = "integration.gateway.channel")
	public void anotherMessage(Message<String> message) throws MessagingException {
		System.out.println("Inside anotherMessage");
		MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
		System.out.println("message " + message);
		MessageBuilder.fromMessage(message);
		Message<String> newMessage = MessageBuilder.withPayload("Welcome, " + message.getPayload() + " to Spring Integration").build();
		replyChannel.send(newMessage);
	}

}
