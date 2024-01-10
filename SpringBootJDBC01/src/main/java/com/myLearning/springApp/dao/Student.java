package com.myLearning.springApp.dao;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private Integer id;
	private Integer age;
	private String city;
	private String name;

	
	public Student()
	{
		System.out.println("Student bean is created");
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", city=" + city + ", name=" + name + "]";
	}
	
	
	
}
