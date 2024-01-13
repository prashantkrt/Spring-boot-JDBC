package com.myLearning.springApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myLearning.springApp.dao.CourseInfo;
import com.myLearning.springApp.dao.SpringJDBC;

@Component
public class StudentCommandLineRunner implements CommandLineRunner {

	@Autowired
	private SpringJDBC springJDBC;

	@Override
	public void run(String... args) throws Exception {
		//adding bulk data into the table
		springJDBC.insert(new CourseInfo(1,"Java"));
		springJDBC.insert(new CourseInfo(2,"C++"));
		springJDBC.insert(new CourseInfo(3,"Python"));
		springJDBC.insert(new CourseInfo(4,"Kotlin"));
		springJDBC.insert(new CourseInfo(5,"C"));
		
		springJDBC.deleteById(4);
		
		System.out.println(springJDBC.findById(2));
		System.out.println(springJDBC.findById(3));
		System.out.println(springJDBC.findById(1));
	}

}
