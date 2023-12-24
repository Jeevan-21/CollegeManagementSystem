package com.management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.model.Student;
import com.util.ApplicationUtil;

public class StudentManagement {
	
	Connection con = DBConnectionManager.getConnection();
	public List<Student> stdDB(List<Student> stdList) {
		ApplicationUtil ap=new ApplicationUtil();
		List<Student> ss=new ArrayList<Student>();
		try {
		PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?,?,?,?,?,?,?,?,?)");
		for(Student std:stdList) {
			ps.setString(1, std.getAdmissionNumber());
			ps.setString(2, std.getStudentId());
			ps.setString(3, std.getStudentName());
			ps.setDate(4, ap.ChangeDate(std.getDob()));
			ps.setInt(5, std.getYearOfStudy());
			ps.setInt(6, std.getYearOfJoining());
			ps.setInt(7, std.getTenthGradeMark());
			ps.setInt(8, std.getTwelthGradeMark());
			ps.setString(9, std.getFirstGraduate());
			ps.setString(10, std.getEmailId());
			ps.setLong(11, std.getPhoneNumber());
			ps.addBatch();
			ps.execute();
			ss.add(std);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return  ss;
	}

	public int updatePhoneNumber(String studId, long newNumber) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = con.prepareStatement("update Student set phone_number=? where student_id=?");
		ps.setLong(1, newNumber);
		ps.setString(2, studId);
		
		int num = ps.executeUpdate();
		return num;
	}

	public int deleteStudent(String stdId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = con.prepareStatement("delete from Student where student_id=?");
		ps.setString(1, stdId);
		int num1 = ps.executeUpdate();
		return num1;
	}

	public ArrayList<Student> viewStudent(int stdId) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Student> stdList = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select * from Student where YEAR_OF_STUDY = ?");
	    ps.setInt(1, stdId);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()) {
	    	Student obj = new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
	    			rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getLong(11));
	    	stdList.add(obj);
	    }
		return stdList;
	}

	public ArrayList<Student> viewStudentId(String stdId) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Student> stdList = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select * from Student where STUDENT_ID = ?");
		ps.setString(1, stdId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Student obj = new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),
	    			rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getLong(11));
	    	stdList.add(obj);
		}
		return stdList;
	}

	public ArrayList<String> existPhoneNo(String studId) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> phoneNo = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select Student_Name,Phone_Number from Student where Student_Id=?");
		ps.setString(1, studId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			phoneNo.add(rs.getString(1));
			phoneNo.add(rs.getString(2));
		}
		return phoneNo;
	}

//	public String countOfId() {
//		// TODO Auto-generated method stub
//		String id = null;
//		try {
//			PreparedStatement ps = con.prepareStatement("select Student_Id from Student Order by desc limit 1;");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				id = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//		return id;
//	}
	
}
