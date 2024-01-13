package com.myLearning.springApp;

import java.util.List;

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
		springJDBC.insert(new CourseInfo(5,"ReactJS"));
		springJDBC.insert(new CourseInfo(6,"HTML"));
		springJDBC.insert(new CourseInfo(7,"CSS"));
		springJDBC.insert(new CourseInfo(8,"NodeJS"));
		
		springJDBC.deleteById(8);
		
		System.out.println(springJDBC.findById(2));
		System.out.println(springJDBC.findById(3));
		System.out.println(springJDBC.findById(1));
		
		List<CourseInfo> listAll = springJDBC.findAll();
		listAll.forEach(n->System.out.println(n));
		
		List<CourseInfo> list = springJDBC.findAll(4);
		list.forEach(n->System.out.println(n));
	}

}
