package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmpService {
	@Autowired
	RestTemplate rt;
	
	@HystrixCommand(fallbackMethod="handleServiceNoAvl")
	public ResponseEntity getEmp(int id){
		return rt.getForEntity("http://boot-app1/app/emp?id="+id, String.class);
		
		/*HttpHeaders headers = new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_XML_VALUE);
		
		HttpEntity data= new HttpEntity<>(headers);
		
		ResponseEntity response= rt
		.exchange("http://localhost:8085/app/emp?id="+Id,
				HttpMethod.GET, data, String.class);*/
	}
	
	public ResponseEntity handleServiceNoAvl(int id){
		return ResponseEntity.ok("EMP service not available, Try Later");
	}

}
