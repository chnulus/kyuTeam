package com.gwt.kyu.shared;

import java.util.ArrayList;

public class Student {

	private String StudentID;
	private String StudentPassword;
	private String StudentName;
	private String Surname;

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public String getStudentPassword() {
		return StudentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}
	
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	
	public ArrayList<Student> getStudentList(){
		
		Student student;
		
		for (int i = 0; i <10; i++) {
			
			student = new Student();
			
			student.setStudentID("1000"+i);
			student.setStudentPassword("1234"+i);
			student.setStudentName("a"+i);
			student.setSurname("b"+i);
			
			studentList.add(student);
			
		}
		
		
		return studentList;
	}
	

}
