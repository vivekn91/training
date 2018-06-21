package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// has mutiple auth was DB, IN-Memory, LDAP, etc
	// We can configure security in root config as well (in WebInitilizer.java in this proj)
	//  ****WebInitilizer.java****
	// getRootConfigurationClasses  add this class (SecurityConfig.java)

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
			.disable().authorizeRequests()
			.antMatchers("/**").hasRole("AMIN")
			.and()
			.httpBasic();
			
		http.csrf()
			.disable().authorizeRequests()
			.antMatchers("/**").hasRole("USER")
			.and()
			.httpBasic();  // displays browser alerts
			//.formLogin(); // dsiplays form
	}
	
	//ithout below code block no secuit
	@Autowired
	public void configurationGlobal(AuthenticationManagerBuilder authBuilder) throws Exception{
		authBuilder.inMemoryAuthentication()
			.withUser("scot1t")
			.password("welcome1")
			.roles("USER");
		authBuilder.inMemoryAuthentication()
			.withUser("arun")
			.password("welcome1")
			.roles("ADMIN");
		authBuilder.inMemoryAuthentication()
			.withUser("pavan")
			.password("welcome1")
			.roles("USERDISABLED");
	}
	
	/*@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception{
		authBuilder
			.jdbcAuthentication()
			.dataSource(dataSource())
			.usersByUsernameQuery("select username,password,enabled from users where username=?")
			.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}
	*/
//	@Bean	
//	public DriverManagerDataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/springdb");
//		dataSource.setUsername("root");
//		dataSource.setPassword("admin");
//		return dataSource;
//	}
}
