package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
	public static void main(String args[]){
		
		ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpService empService = context.getBean(EmpService.class);
		
		//System.out.println(empService.RegisterEmployee(100, "Ramesh", "Chennai", 67000));
		
		WriterApp app = context.getBean(WriterApp.class);
		
		app.printText("Hello World");
	}
}
