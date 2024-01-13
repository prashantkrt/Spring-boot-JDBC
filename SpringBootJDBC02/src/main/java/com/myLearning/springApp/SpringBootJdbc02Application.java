package com.myLearning.springApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//import com.myLearning.springApp.dao.SpringJDBC;

@SpringBootApplication
public class SpringBootJdbc02Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context=   SpringApplication.run(SpringBootJdbc02Application.class, args);
//		SpringJDBC springJDBC = context.getBean(SpringJDBC.class);
//		springJDBC.insert();
		context.close();
	}
}
