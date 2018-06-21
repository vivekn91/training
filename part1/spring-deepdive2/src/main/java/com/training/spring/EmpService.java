package com.training.spring;

import com.training.spring.entity.Emp;

public class EmpService {
	
	EmpDao dao;
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	public String RegisterEmployee(int empId, String name, String city, double salary){
		String response = dao.save(new Emp(empId, name, city, salary));
		return response;
	}

}
