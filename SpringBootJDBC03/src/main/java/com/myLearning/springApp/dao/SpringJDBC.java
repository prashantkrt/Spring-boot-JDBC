package com.myLearning.springApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	private static final String SQL_QUERY_SELECT_ALL = "select id,name from Course ";

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

//      return jdbc.queryForObject(SQL_QUERY_SELECT, new BeanPropertyRowMapper<>(CourseInfo.class), id);
//		RowMapper rowMapper = (rs, rowNum) -> {
//			CourseInfo info = new CourseInfo(rs.getInt(1), rs.getString(2));
//			return info;
//		};		

		return (CourseInfo) jdbc.queryForObject(SQL_QUERY_SELECT,
				(rs, rowNum) -> new CourseInfo(rs.getInt(1), rs.getString(2)), id);
	}

	public List<CourseInfo> findAll() {
		List<CourseInfo> list = jdbc.query(SQL_QUERY_SELECT_ALL, (rs, n) -> {
			CourseInfo info = new CourseInfo(rs.getInt(1), rs.getString(2));
			return info;
		});
		return list;
	}
	
	public List<CourseInfo> findAll(long id) {
		List<CourseInfo> list = jdbc.query(SQL_QUERY_SELECT, (rs, n) -> {
			CourseInfo info = new CourseInfo(rs.getInt(1), rs.getString(2));
			return info;
		},id);
		return list;
	}
}
