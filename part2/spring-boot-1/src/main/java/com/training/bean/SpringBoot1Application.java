package com.training.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com")
@EnableJpaRepositories(basePackages={"com.training.repo"})
@EnableEurekaClient
public class SpringBoot1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}
	
	/*
	 * Check below URLS in console after incl actuator
	 * 
	 * app/mappings
	 * /heapdump 
	 * 
	 */
}
