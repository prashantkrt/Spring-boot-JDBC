package com.myLearning.springApp.dao;

import java.util.List;

//import java.sql.ResultSet;
//import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//DAO Layer
//any code which defines the persistence logic then apply @Repository there
@Repository(value="dao")
public class StudentDaoImpl implements IStudentDAO {

	private static final String SELECT_SQL_QUERY = "Select * from StudentTable where Id=? and Name=?";
	private static final String SELECT_SQL_QUERY2 = "Select * from StudentTable where Name=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// traditional approach
	/*
	 * private static class RowMapperImp implements RowMapper<StudentTableBO> {
	 * 	 
	 *  @Override
	 *  public StudentTableBO mapRow(ResultSet rs, int rowNum) throws SQLException {
	 *   return new StudentTableBO(rs.getInt(1), rs.getInt(2),
	 *    rs.getString(3), rs.getString(4));
	 *  }	  
	 * }
	 * 
	 * @Override public StudentTableBO getStudentById(String name, int id) {
	 * 
	 * return jdbcTemplate.queryForObject(SELECT_SQL_QUERY, new RowMapperImp(), id,
	 * name); }
	 */

	//annonymous inner class
	/*
	 * @Override
	 * public StudentTableBO getStudentById(String name, int id) {
	 * return jdbcTemplate.queryForObject(SELECT_SQL_QUERY, new RowMapper<StudentTableBO>()
	 * {	  
	 *   @Override 
	 *   public StudentTableBO mapRow(ResultSet rs, int rowNum) throws SQLException {
	 *    return new StudentTableBO(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4)); 
	 *   } 
	 *  }, id, name);
	 * }
	 */
	
	//lambda
	/*
	 * @Override 
	 * public StudentTableBO getStudentById(String name, int id) {
	 * 
	 * return jdbcTemplate.queryForObject(SELECT_SQL_QUERY, (rowSet, rowNumber) -> {
	 * return new StudentTableBO(rowSet.getInt(1), rowSet.getInt(2),
	 * rowSet.getString(3), rowSet.getString(4)); }, id, name); }
	 */
	
	//lambda lesser code
	@Override
	public StudentTableBO getStudentById(String name, int id) {
		return jdbcTemplate.queryForObject(SELECT_SQL_QUERY, (rowSet, rowNumber) -> new StudentTableBO(rowSet.getInt(1),
				rowSet.getInt(2), rowSet.getString(3), rowSet.getString(4)), id, name);
	}
	
	/* jdbcTemplate.query for multiple rows
	 * jdbcTemplate.queryForObject for single row
	 * */

	@Override
	public List<StudentTableBO> getStudentById(String name) {
		List<StudentTableBO> list = (List<StudentTableBO>) jdbcTemplate.query(SELECT_SQL_QUERY2, (rowSet, rowNumber) -> new StudentTableBO(rowSet.getInt(1),
				rowSet.getInt(2), rowSet.getString(3), rowSet.getString(4)),name);
		return list;
	}
}
