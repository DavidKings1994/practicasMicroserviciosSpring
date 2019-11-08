package com.reyes.activemqreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageConsumer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@JmsListener(destination = "test-queue")
	public void listener(String message) {
		logger.info("Message received {} ", message);
	}
}