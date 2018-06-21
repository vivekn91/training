package com.training.spring;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClinet1 {

	public static void main(String[] args) {
		String userDetails ="scot1t:welcome1";
		String encodeBase64 = new String(Base64.encodeBase64String(userDetails.getBytes()));
		
		System.out.println("Cred ::"+ encodeBase64);
		
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept","application/json");
		headers.set("Authorization","Basic "+encodeBase64);
		
		HttpEntity httpEntity = new HttpEntity<>(headers);
		
		ResponseEntity response = restTemplate
				.exchange("http://localhost:8080/spring-restful/emp?id=101",
						HttpMethod.GET, httpEntity, String.class);
		System.out.println(response.getBody());	
	}

}
