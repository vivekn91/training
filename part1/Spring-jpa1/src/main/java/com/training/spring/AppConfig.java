package com.training.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.training")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean	
	public BasicDataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		//equvalent to sesson factory
		LocalContainerEntityManagerFactoryBean localEntityManage=  new LocalContainerEntityManagerFactoryBean();
		localEntityManage.setDataSource(dataSource());
		
		HibernateJpaVendorAdapter hibernateAdapter= new HibernateJpaVendorAdapter();
		hibernateAdapter.setDatabase(Database.MYSQL);
		hibernateAdapter.setShowSql(true);
		
		
		localEntityManage.setPackagesToScan("com.training.spring.entity"); // mention entity package
		localEntityManage.setJpaVendorAdapter(hibernateAdapter);
		
		return localEntityManage;
	}
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager txnMgr = new JpaTransactionManager();
		txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
		return txnMgr;
	}
}
