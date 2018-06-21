package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

	public static void main(String args[]){
		ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpService empService= context.getBean(EmpService.class);
		
		//empService.RegisterEmployee(106, "Tiger", "Dandeli", 56000);
		//empService.getAllEmployee();
		System.out.println(empService.deleteEmployee(106));
	}
}
