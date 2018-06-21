package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.spring.entity.Emp;

public class AppMain {
	public static void main(String args[]){
		ApplicationContext  context = new ClassPathXmlApplicationContext("context.xml");
		
		EmpService empService = context.getBean(EmpService.class);
		
		System.out.println(empService.RegisterEmployee(100, "Ramesh", "Chennai", 67000));
	}
}
