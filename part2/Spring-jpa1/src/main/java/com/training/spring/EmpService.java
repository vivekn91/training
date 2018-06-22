package com.training.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.entity.Emp;

@Service
public class EmpService {
	
	@Autowired
	EmpDao dao;
	
	public String RegisterEmployee(int empId, String name, String city, double salary){
		String response;
		int recordUpdated = dao.save(new Emp(empId, name, city, salary));
		if(recordUpdated >0){
			response = "Saved one record :: "+recordUpdated;
		}else{
			response ="Emp Not saved";
		}
		return response;
	}
	
	public String findEmployee(int empId){
		String response;
		Emp e = dao.findById(empId);
		if(e== null){
			response ="Employee Not found :: "+empId;
		}else{
			response ="Employee found :: "+empId;
		}
		return response;
	}
	
	public String saveListOfEmp(List<Emp> empList){
		String response;
		int recordUpdated = dao.saveEmpList(empList);
		if(recordUpdated >0){
			response = "Emp list saved "+empList.size();
		}else{
			response ="Emp List Not saved "+empList.size();
		}
		return response;
	}
	
	public void getAllEmployee(){
		List<Emp> empList = dao.findAll();
		for (Emp emp : empList) {
			System.out.println(emp.getEmpId());
		}
	}
	
	public String deleteEmployee(int empId){
		String response;
		int isDeleted = dao.delete(empId);
		if(isDeleted > 0){
			response ="Employee Deleted :: "+empId;
		}else{
			response ="Employee not Deleted :: "+empId;
		}
		return response;
	}

}
