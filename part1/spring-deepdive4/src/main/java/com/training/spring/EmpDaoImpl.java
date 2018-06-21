package com.training.spring;

import org.springframework.stereotype.Repository;

import com.training.spring.entity.Emp;

@Repository("jdbcEmp")
public class EmpDaoImpl implements EmpDao {

	@Override
	public String save(Emp emp) {
		// TODO Auto-generated method stub
		return "JDBC :: Save flow ::  "+emp.getEmpId();
	}

}
