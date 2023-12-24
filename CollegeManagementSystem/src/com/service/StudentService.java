package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.management.StudentManagement;
import com.model.Student;
import com.util.ApplicationUtil;


public class StudentService {
	
	StudentManagement sm = new StudentManagement();
	public  List<Student> addStudent(String studArr[]) {
		ArrayList<String> extractStudentList = ApplicationUtil.extractDetails(studArr);
		List<Student> studentList = buildStudentList(extractStudentList);
		List<Student> startObj = sm.stdDB(studentList);
		
		return startObj;
	}
	
	public List<Student> buildStudentList(ArrayList<String> stdtList){
		
		List<Student> studentList = new ArrayList<>();
		
		for(String str:stdtList) {
			String []arr = str.split(":");
			String AddNum = arr[0];
			String studName = arr[1];
			String DOB = arr[2];
			int YearofStudy = Integer.parseInt(arr[3]);
			int YearofJoining = Integer.parseInt(arr[4]);
			int tenthMark = Integer.parseInt(arr[5]);
			int twelthMark = Integer.parseInt(arr[6]);
			String firstGraduate = arr[7];
			String mailId = arr[8];
			long phoneNum = Long.parseLong(arr[9]);
			String studId = studIdGenerate();
			
			Student std = new Student(AddNum,studId,studName,DOB,YearofStudy,YearofJoining,
					tenthMark,twelthMark,firstGraduate,mailId,phoneNum);
			
			studentList.add(std);
		}
		return studentList;
	}

	static int id = 1;
	private String studIdGenerate() {
		// TODO Auto-generated method stub5
		String num = String.format("%03d",id);
		id++;
		return "CRISP" + num;
	}

	public int updatePhoneNumber(String studId, long oldNumber) throws SQLException {
		// TODO Auto-generated method stub
			int num = sm.updatePhoneNumber(studId,oldNumber);
		return num;
	}

	public int deleteStudent(String stdId) throws SQLException {
		// TODO Auto-generated method stub
		int num1 = sm.deleteStudent(stdId);
		return num1;
	}

	public ArrayList<Student> viewStudent(int stdId) throws SQLException {
		// TODO Auto-generated method stub
	    return sm.viewStudent(stdId);
	
	}

	public ArrayList<Student> viewUsingStudentId(String stdId) throws SQLException {
		// TODO Auto-generated method stub
		return sm.viewStudentId(stdId);
	}

	public ArrayList<String> existPhoneNo(String studId) throws SQLException {
		// TODO Auto-generated method stub
		return sm.existPhoneNo(studId);
	}
}
