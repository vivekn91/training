package com.training.bean;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.repo.EmpRepo;

@RestController
public class EmpRESTController {
	
	@Autowired
	EmpRepo empRepo;
		
	@RequestMapping(path="/information",method=RequestMethod.GET,produces={MediaType.TEXT_PLAIN_VALUE})
	public String info(){
		return "This is spring RESTful service";
	}
	
	@RequestMapping(path="/greet/{name}",method=RequestMethod.GET)
	public String greet(@PathVariable("name") String name){
		return "Hello "+name;
	}
	
	@RequestMapping(path="/emp",method=RequestMethod.GET, 
			produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getEmp(@RequestParam("id") int id, ServletRequest reg){
		System.out.println("******************");
		System.out.println("Request served by :: "+reg.getLocalAddr()+" : "+reg.getLocalPort());
		System.out.println("******************");
		Emp emp= empRepo.findOne(id);
		if(emp != null){
			return ResponseEntity.ok(emp);
		}else{
			return  ResponseEntity.ok("Employee does not exists");
		}
	}
	
	@RequestMapping(path="/save",method=RequestMethod.POST,
			consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity save(@RequestBody Emp emp){
		Emp savedUser = empRepo.save(emp);
		if(savedUser.getEmpId() == emp.getEmpId()){
			return ResponseEntity.ok("Emp saved Successfully");
		}else{
			return ResponseEntity.ok("Emp not saved ");
		}
	}
	
	
	
}
