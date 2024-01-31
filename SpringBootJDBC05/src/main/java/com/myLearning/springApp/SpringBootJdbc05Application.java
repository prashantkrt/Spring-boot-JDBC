package com.myLearning.springApp;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.myLearning.springApp.dao.StudentDaoImpl;
import com.myLearning.springApp.dao.StudentTableBO;

@SpringBootApplication
public class SpringBootJdbc05Application {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpringBootJdbc05Application.class, args);
	
	StudentDaoImpl dao = (StudentDaoImpl)context.getBean("dao");
	StudentTableBO bo = dao.getStudentById("Gajadhar", 1);
	System.out.println(bo);	
	
	List<StudentTableBO> list = dao.getStudentById("Ballu");
	list.forEach(i->System.out.println(i));

	
	((ConfigurableApplicationContext)context).close();
	}

}
