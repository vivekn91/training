package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/emp")
public class EmpClientService {
	
	@Autowired
	EmpService empService;
	
	
	@RequestMapping(path="/get/{id}",produces={MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity fetch(@PathVariable("id") int Id){
		ResponseEntity response= empService.getEmp(Id);
		
		return response;
		
	}
}
