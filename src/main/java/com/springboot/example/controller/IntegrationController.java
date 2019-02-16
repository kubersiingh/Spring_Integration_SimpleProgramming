package com.springboot.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.service.IntegrationGatway;

@RestController
@RequestMapping("/integrate")
public class IntegrationController {

	@Autowired
	private IntegrationGatway integrationGateway;
	
	@GetMapping(value = "{name}")
	public String getMessageFromIntegrationService(@PathVariable("name") String name) {
		System.out.println("Inside Controller getMessageFromIntegrationService");
		return integrationGateway.sendMessage(name);
	}
}
