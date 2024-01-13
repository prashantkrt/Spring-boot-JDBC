package com.myLearning.springApp.dao;

public class CourseInfo {

	private Integer courseId;

	private String cName;

	public CourseInfo() {
		System.out.println("Course info zero param constructor");
	}

	public CourseInfo(Integer courseId, String cName) {
		super();
		this.courseId = courseId;
		this.cName = cName;
		System.out.println("Course info all params constructor");
	}

	public Integer getCourseId() {
		return courseId;
	}

	public String getcName() {
		return cName;
	}

	@Override
	public String toString() {
		return "CourseInfo [courseId=" + courseId + ", cName=" + cName + "]";
	}
}
