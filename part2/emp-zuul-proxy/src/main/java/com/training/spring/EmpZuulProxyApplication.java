package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EmpZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpZuulProxyApplication.class, args);
	}
	
	/*
	 * Check below url
	 * 
	 * http://localhost:9080/api/redirect
	 * 		--> calls redirect
	 * 
	 * http://localhost:9080/api/host/emp/get/100
	 * 		--> calls host (emp-client-service project)
	 * 
	 * http://localhost:9080/api/service/app/emp?id=100
	 * 		--> calls by service (spring-boot-1 project)
	 * 
	 * 
	 * 
	 */
}
