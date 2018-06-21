package com.training.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.training")
@EnableWebMvc
@EnableTransactionManagement
public class WebConfig {
	
	@Bean	
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("WEB-INF/pages/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DriverManagerDataSource datasource){
		//equvalent to sesson factory
		LocalContainerEntityManagerFactoryBean localEntityManage=  new LocalContainerEntityManagerFactoryBean();
		localEntityManage.setDataSource(datasource);
		
		HibernateJpaVendorAdapter hibernateAdapter= new HibernateJpaVendorAdapter();
		hibernateAdapter.setDatabase(Database.MYSQL);
		hibernateAdapter.setShowSql(true);
		
		
		localEntityManage.setPackagesToScan("com.training.bean"); // mention entity package
		localEntityManage.setJpaVendorAdapter(hibernateAdapter);
		
		return localEntityManage;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityFac){
		JpaTransactionManager txnMgr = new JpaTransactionManager();
		txnMgr.setEntityManagerFactory(entityFac);
		return txnMgr;
	}
}
