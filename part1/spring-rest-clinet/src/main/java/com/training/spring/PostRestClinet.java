package com.training.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class PostRestClinet {
  public static void main(String args[]){
	  
	  RestTemplate restTemplate = new RestTemplate();
	  
	  String empJson ="{\"empId\":107,\"name\":\"raja\",\"city\":\"chennai\",\"salary\":50000}";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept",MediaType.TEXT_PLAIN_VALUE);
		headers.set("content-type",MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity data= new HttpEntity<>(empJson,headers);
		
		ResponseEntity resp = restTemplate.exchange("http://localhost:8085/app/save", 
				HttpMethod.POST, data, String.class);
		
		System.out.println(resp.getBody());
  }
}
