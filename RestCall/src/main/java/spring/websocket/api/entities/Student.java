package spring.websocket.api.entities;

import org.springframework.stereotype.Component;


public class Student {
	private int StudentId;
	private String studentName;
	private String address;
	public Student(int studentId, String studentName, String address) {
		super();
		StudentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student() {
	
		
	}
	

}
