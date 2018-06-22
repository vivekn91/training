package com.training.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.spring.entity.Emp;

public class AppMain2 {
	
	public static void main(String args[]){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		EmpService empSErvice = context.getBean(EmpService.class);
		
		List<Emp> empList = new ArrayList<>();
		
		Emp emp1 = new Emp(110, "Vivek2", "3", 5000);
		empList.add(emp1);
		Emp emp2 = new Emp(112, "Vivek3", "3", 5000);
		empList.add(emp2);
		Emp emp3 = new Emp(111, "Vivek4", "3", 5000);
		empList.add(emp3);

		
		//System.out.println(empSErvice.RegisterEmployee(107, "Vivek", "3", 5000));
		//System.out.println(empSErvice.findEmployee(108));
		System.out.println(empSErvice.saveListOfEmp(empList));
			
	}

}
