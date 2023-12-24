package com.model;

public class Enrollment {
	
	private String enrollmentId;
	private String studentId;
	private String courseId;
	private String feesStatus;
	
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getFeesStatus() {
		return feesStatus;
	}
	public void setFeesStatus(String feesStatus) {
		this.feesStatus = feesStatus;
	}
	
	public Enrollment(String enrollmentId, String studentId, String courseId, String feesStatus) {
		super();
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.feesStatus = feesStatus;
	}
	
	public Enrollment(String enrollmentId, String studentId, String courseId) {
		super();
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	public Enrollment() {
		// TODO Auto-generated constructor stub
	}
}
