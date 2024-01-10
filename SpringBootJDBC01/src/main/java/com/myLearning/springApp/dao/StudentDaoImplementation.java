package com.myLearning.springApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImplementation") // component + database
public class StudentDaoImplementation implements IStudentDao {

	private static final String SQL_QUERY = "Select * from StudentTable";
	List<Student> list =null;
	@Autowired // Using HikariCP collection-pooling mechanism
	private DataSource dataSource;

	public StudentDaoImplementation() {
		System.out.println("StudentDaoImplementation bean created");
	}

	@Override
	public List<Student> getTheSudent() {
		System.out.println("DataSource :"+dataSource.getClass().getName());
		try {
	      Connection connect =dataSource.getConnection();
	      PreparedStatement statement = connect.prepareStatement(SQL_QUERY);
	      ResultSet result = statement.executeQuery();
	      list = new ArrayList<>();
	      while(result.next())
	      {
	    	  Student student = new Student();
	    	  Integer id = result.getInt(1);
	    	  student.setId(id);
	    	  Integer age = result.getInt(2);
	    	  student.setAge(age);
	    	  String city = result.getString(3);
	    	  student.setCity(city);
	    	  String name = result.getString(4);
	    	  student.setName(name);
	    	  list.add(student);
	      }
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
