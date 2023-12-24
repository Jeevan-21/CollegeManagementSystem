package com.model;

public class Attendance {
	String attendanceId;
	String studentId;
	String enrollmentId;
	int semester;
	int totalWorkingDays;
	int presentDays;
	int absentDays;
	int attendancePercentage;
	
	public String getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getTotalWorkingDays() {
		return totalWorkingDays;
	}
	public void setTotalWorkingDays(int totalWorkingDays) {
		this.totalWorkingDays = totalWorkingDays;
	}
	public int getPresentDays() {
		return presentDays;
	}
	public void setPresentDays(int presentDays) {
		this.presentDays = presentDays;
	}
	public int getAbsentDays() {
		return absentDays;
	}
	public void setAbsentDays(int absentDays) {
		this.absentDays = absentDays;
	}
	public int getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(int attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	
	public Attendance(String attendanceId, String studentId, String enrollmentId, int semester, int totalWorkingDays,
			int presentDays, int absentDays, int attendancePercentage) {
		super();
		this.attendanceId = attendanceId;
		this.studentId = studentId;
		this.enrollmentId = enrollmentId;
		this.semester = semester;
		this.totalWorkingDays = totalWorkingDays;
		this.presentDays = presentDays;
		this.absentDays = absentDays;
		this.attendancePercentage = attendancePercentage;
	}

}
