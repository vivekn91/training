package com.training.spring;

import com.training.spring.entity.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	public String save(Emp emp) {
		// TODO Auto-generated method stub
		return "JDBC :: Save flow ::  "+emp.getEmpId();
	}

}
