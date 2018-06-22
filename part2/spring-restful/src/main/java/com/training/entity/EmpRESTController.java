package com.training.entity;

import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpRESTController {

	static	HashMap<Integer, Emp> empList = new HashMap<>();
	
	static{
		empList.put(100, new Emp(100, "scott","America",7500));
		empList.put(101, new Emp(101, "Arshad","Chennai",7500));
		empList.put(102, new Emp(102, "Raja","Chennai",7500));
		empList.put(103, new Emp(103, "vivek","Chennai",7500));
	}
	
	@RequestMapping(path="/info",method=RequestMethod.GET)
	public String info(){
		return "This is spring RESTful service";
	}
	
	@RequestMapping(path="/greet/{name}",method=RequestMethod.GET)
	public String greet(@PathVariable("name") String name){
		return "Hello "+name;
	}
	
	@RequestMapping(path="/emp",method=RequestMethod.GET, 
			produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getEmp(@RequestParam("id") int id){
		Emp emp= empList.get(id);
		if(emp != null){
			return ResponseEntity.ok(emp);
		}else{
			return  ResponseEntity.ok("Employee does not exists");
		}
	}
	
	
}
