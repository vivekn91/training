package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Mail mail = context.getBean(Mail.class);
		System.out.println(mail.toString());
		
		mail.getMessage().setBody("Lest break for lunch");
		
		Mail mail1 = context.getBean(Mail.class);
		
		System.out.println(mail1.toString());
	}
}
