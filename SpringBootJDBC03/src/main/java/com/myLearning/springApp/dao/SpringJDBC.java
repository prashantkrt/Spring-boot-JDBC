package com.myLearning.springApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringJDBC {

	// private static final String SQL_QUERY = "Insert into Student
	// values(1,'Rajat','Jaipur',39)";
	// private static final String SQL_QUERY_DELETE= "delete from Course where
	// id=3";

	private static final String SQL_QUERY_INSERT = "Insert into Course values(?,?)";
	private static final String SQL_QUERY_DELETE = "delete from Course where id=?";
	private static final String SQL_QUERY_SELECT = "select id,name from Course where id=?";

	@Autowired
	private JdbcTemplate jdbc;

	/*
	 * public void insert() {
	 * System.out.println("Implementing class of JDBCTemplate "+jdbc.getClass().
	 * getName()); jdbc.update(SQL_QUERY); }
	 */

	public void insert(CourseInfo info) {
		System.out.println("Implementing class of JDBCTemplate " + jdbc.getClass().getName());
		// jdbc.update(SQL_QUERY,1,"Java");
		int rowAffected = jdbc.update(SQL_QUERY_INSERT, info.getCourseId(), info.getcName());
		System.out.println("Rows affected : " + rowAffected);
	}

	/*
	 * public void deleteById() { jdbc.update(SQL_QUERY_DELETE); s}
	 */

	public void deleteById(long id) {
		int rowAffected = jdbc.update(SQL_QUERY_DELETE, id);
		System.out.println("Rows affected/deleted : " + rowAffected);
	}

	public CourseInfo findById(long id) {
		return jdbc.queryForObject(SQL_QUERY_SELECT, new BeanPropertyRowMapper<>(CourseInfo.class), id);
	}
}
