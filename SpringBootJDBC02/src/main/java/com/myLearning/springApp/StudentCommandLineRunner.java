package com.myLearning.springApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myLearning.springApp.dao.SpringJDBC;

/*This is optional, just to learn about the CommandLineRunner*/


@Component
public class StudentCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private SpringJDBC springJDBC;
	
	@Override
	public void run(String... args) throws Exception {		
     springJDBC.insert();
	}

}
