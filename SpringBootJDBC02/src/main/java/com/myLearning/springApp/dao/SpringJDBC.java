package com.myLearning.springApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJDBC {
	
	private static final String SQL_QUERY = "Insert into Student values(2,'Rajat','Jaipur',39)";
	@Autowired
	private JdbcTemplate jdbc;
	
	public void insert()
	{
		jdbc.update(SQL_QUERY);
	}
	
}
