package com.training.spring;

import java.util.List;

import com.training.spring.entity.Emp;

public interface EmpDao {

	public int save(Emp emp);
	public int delete(int empno );
	public Emp findById(int empno );
	public List<Emp> findAll();
	public int saveEmpList(List<Emp> emp);
	
}
