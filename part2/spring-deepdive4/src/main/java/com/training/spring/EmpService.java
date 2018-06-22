package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.training.spring.entity.Emp;

@Service
public class EmpService {
	@Autowired
	@Qualifier("jpaEmp")
	EmpDao dao;

//	@Autowire avoid getters and serrter methods
//	public void setDao(EmpDao dao) {
//		this.dao = dao;
//	}

	public String RegisterEmployee(int empId, String name, String city, double salary){
		String response = dao.save(new Emp(empId, name, city, salary));
		return response;
	}

}
