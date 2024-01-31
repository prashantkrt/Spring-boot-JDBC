package com.myLearning.springApp.dao;

import java.util.List;

public interface IStudentDAO {

	public StudentTableBO getStudentById(String name ,int id);
	
	public List<StudentTableBO> getStudentById(String name);

}
