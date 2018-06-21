package com.training.spring;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	// name of the method name "BEAN name" --> check in config
	@JmsListener(destination = "myqueue2", containerFactory = "listenerFactory")
	public void getMessage(Message mess) throws Exception {
		TextMessage message = (TextMessage) mess;
		System.out.println("Resgiter :: " + message.getText());
	}
}
