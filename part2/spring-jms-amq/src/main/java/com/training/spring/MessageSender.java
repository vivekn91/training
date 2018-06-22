package com.training.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {

	public static void main(String args[]) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JMSConfig.class);
		JmsTemplate jmsTemplate = applicationContext.getBean(JmsTemplate.class);

		jmsTemplate.send("myqueue2",new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				message.setText("My first JMS app :: myqueue2 :: raja ");
				return message;
			}
		});
	}
}
