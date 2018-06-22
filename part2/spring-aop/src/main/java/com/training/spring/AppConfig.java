package com.training.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.training.spring")
@EnableAspectJAutoProxy
public class AppConfig {
	
	

}
