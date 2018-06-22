package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmpEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpEurekaServerApplication.class, args);
	}
	
	/***
	 * Our serverice should be Eureka client
	 * 
	 * To create eureka-client copy '<dependencyMangement>' block from POM
	 * 
	 * Below is made false because it registers other eureka servers
	 *     register-with-eureka: false
     *		fetch-registry: false
     *
     *
     *Load balancer
     *
     *1. Spring Eureka
     *2. Load balancer :: Spring Ribbon
     *3. Circuit Breakers :: Spring-Hystrix
     *4. API Gateway :: Zuul
     *
     *CHECK
     *
     *	http://localhost:8761/
	 */
}
