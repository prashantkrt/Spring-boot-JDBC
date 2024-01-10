package com.myLearning.springApp;

//import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.myLearning.springApp.dao.Student;
import com.myLearning.springApp.dao.StudentDaoImplementation;

@SpringBootApplication
public class SpringBootJdbc01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootJdbc01Application.class, args);

		StudentDaoImplementation student = context.getBean(StudentDaoImplementation.class);

		List<Student> list = student.getTheSudent();
		//type 1 
//		Iterator<Student> itr = list.iterator();
//
//		while (itr.hasNext()) {
//			System.out.println(itr.next() + " ");
//		}
//		
		//type 2 
//		for(Student l : list)
//		{
//			System.out.println(l+" ");
//		}
		
		list.forEach(stu->System.out.println(stu));

		context.close();
	}

}
