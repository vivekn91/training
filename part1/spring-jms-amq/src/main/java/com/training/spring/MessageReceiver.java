package com.training.spring;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageReceiver {
	public static void main(String args[]) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JMSConfig.class);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		TextMessage message = (TextMessage) jmsTemplate.receive();
		try {
			System.out.println(message.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
