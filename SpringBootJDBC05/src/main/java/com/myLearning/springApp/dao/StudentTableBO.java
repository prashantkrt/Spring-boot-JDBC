package com.myLearning.springApp.dao;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

//business object
@Data
@AllArgsConstructor
@Component(value="bo")
public class StudentTableBO {
	private Integer id;
	private Integer age;
	private String city;
	private String name;
	
	
	public StudentTableBO()
	{
		System.out.println("Studnet BO bean is created...BO");
	}	

}
