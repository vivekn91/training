package com.training.spring;

import org.springframework.stereotype.Repository;

import com.training.spring.entity.Emp;

@Repository("jpaEmp")
public class EmpDaoJPAImpl implements EmpDao{

	@Override
	public String save(Emp emp) {
		// TODO Auto-generated method stub
		return "JAP :: SAVE :: "+emp.getEmpId();
	}
	
	

}
