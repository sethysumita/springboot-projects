package com.maven.spring.SpringCrud;
//it is a bean
public class Student {
	private int studentId;
	private String studentName;
	private String address;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public Student(int studentId, String studentName, String address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address
				+ ", getStudentId()=" + getStudentId() + ", getStudentName()=" + getStudentName() + ", getAddress()="
				+ getAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
