package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bootstrap {
	public static void main(String args[]) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JMSConfig.class);
		System.out.println("Lsitener ready ...");
	}
}
