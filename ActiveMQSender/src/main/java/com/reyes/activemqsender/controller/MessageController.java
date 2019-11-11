package com.reyes.activemqsender.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	private Queue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("/message/{message}")
	@SendTo("/test-queue")
	public ResponseEntity<String> publish(@PathVariable("message") String message) {
		jmsTemplate.convertAndSend(queue, message);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
