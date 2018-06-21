package com.training.spring;

import com.training.spring.entity.Emp;

public class EmpDaoJPAImpl implements EmpDao{

	@Override
	public String save(Emp emp) {
		// TODO Auto-generated method stub
		return "JAP :: SAVE :: "+emp.getEmpId();
	}
	
	

}
