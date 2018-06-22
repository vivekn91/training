package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WriterApp {
	
	@Autowired
	@Qualifier("deco1")
	Writer writer;
	
	public void printText(String s){
		writer.write(s);
	}
	
//	public static void main(String args[]){
//	ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
//	
//	WriterService ws = context.getBean(WriterService.class);
//	
//	ws.write("Hello World");
//	}
}
