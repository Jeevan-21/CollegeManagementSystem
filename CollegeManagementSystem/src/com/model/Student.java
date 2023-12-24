package com.model;

public class Student {
	private String admissionNumber;
	private String studentId;
	private String studentName;
	private String dob;
	private int yearOfStudy;
	private int yearOfJoining;
	private int tenthGradeMark;
	private int twelthGradeMark;
	private String firstGraduate;
	private String emailId;
	private long phoneNumber;
	public static int id = 1;
	
	public Student(String admissionNumber, String studentId, String studentName, String dob, int yearOfStudy,
			int yearOfJoining, int tenthGradeMark, int twelthGradeMark, String firstGraduate, String emailId,
			long phoneNumber) {
		super();
		this.admissionNumber = admissionNumber;
		this.studentId = studentId;
		this.studentName = studentName;
		this.dob = dob;
		this.yearOfStudy = yearOfStudy;
		this.yearOfJoining = yearOfJoining;
		this.tenthGradeMark = tenthGradeMark;
		this.twelthGradeMark = twelthGradeMark;
		this.firstGraduate = firstGraduate;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	
	public String getAdmissionNumber() {
		return admissionNumber;
	}
	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public int getTenthGradeMark() {
		return tenthGradeMark;
	}
	public void setTenthGradeMark(int tenthGradeMark) {
		this.tenthGradeMark = tenthGradeMark;
	}
	public int getTwelthGradeMark() {
		return twelthGradeMark;
	}
	public void setTwelthGradeMark(int twelthGradeMark) {
		this.twelthGradeMark = twelthGradeMark;
	}
	public String getFirstGraduate() {
		return firstGraduate;
	}
	public void setFirstGraduate(String firstGraduate) {
		this.firstGraduate = firstGraduate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
