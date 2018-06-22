package com.training.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class AppMain {
	
	public static void main(String args[]){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		int isUpdated=jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = connection.prepareStatement("insert into emp (empno,name,address,salary) values (?,?,?,?)");
				preparedStatement.setString(1, "105");
				preparedStatement.setString(2, "Vivek");
				preparedStatement.setString(3, "N");
				preparedStatement.setString(4, "1000");
				return preparedStatement;
			}
		});
		
		if(isUpdated >0){
			System.out.println("No of rows updated ::: "+isUpdated);
		}else{
			System.out.println("Not updated");
		}
		
	}

}
