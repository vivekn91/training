package com.training.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.entity.Emp;

 
public class EmpDaoJdbcImpl implements EmpDao {
	@Autowired
	// @Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Emp emp) {
		int isUpdated = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into emp (empno,name,address,salary) values (?,?,?,?)");
				preparedStatement.setInt(1, emp.getEmpId());
				preparedStatement.setString(2, emp.getName());
				preparedStatement.setString(3, emp.getCity());
				preparedStatement.setDouble(4, emp.getSalary());
				return preparedStatement;
			}
		});
		return isUpdated;
	}

	@Override
	public int delete(int empno) {
		int isDeleted = jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from emp where empno=?");
				preparedStatement.setInt(1, empno);
				return preparedStatement;
			}
		});
		return isDeleted;
	}

	@Override
	public Emp findById(int empno) {
		Emp emp = null;
		try {
			emp = jdbcTemplate.queryForObject("Select * from emp where empno=" + empno, new RowMapper<Emp>() {

				@Override
				public Emp mapRow(ResultSet rs, int index) throws SQLException {
					// TODO Auto-generated method stub
					return new Emp(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
							rs.getDouble("salary"));
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
			emp = null;
		}
		return emp;
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> empList = jdbcTemplate.query("Select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				return new Emp(rs.getInt("empno"), rs.getString("name"), rs.getString("address"),
						rs.getDouble("salary"));
			}

		});
		return empList;

	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED )
	public int saveEmpList(List<Emp> empList) {
		int count=0;
		for (Emp emp : empList) {
			save(emp);
			count = count +1;
		}
		return count;
	}

}
