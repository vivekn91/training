package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class EmpClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpClientServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate rt(){
		return new RestTemplate();
	}
	
	/*
	 * 
	 * check
	 * 
	 * http://localhost:9090/emp/get/{id}
	 */
}
