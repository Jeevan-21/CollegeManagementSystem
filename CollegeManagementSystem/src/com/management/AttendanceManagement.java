package com.management;

import java.sql.*;
import java.util.ArrayList;
import com.model.Attendance;

public class AttendanceManagement {
	
	Connection con = DBConnectionManager.getConnection();

	public ArrayList<Attendance> insertAttendance(ArrayList<Attendance> attendanceObj) {
		// TODO Auto-generated method stub
		
		ArrayList<Attendance> at = new ArrayList<Attendance>();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO ATTENDANCE VALUES(?,?,?,?,?,?,?,?)");
			for(Attendance att : attendanceObj) {
				ps.setString(1, att.getAttendanceId());
				ps.setString(2, att.getStudentId());
				ps.setString(3, att.getEnrollmentId());
				ps.setInt(4, att.getSemester());
				ps.setInt(5, att.getTotalWorkingDays());
				ps.setInt(6, att.getPresentDays());
				ps.setInt(7, att.getAbsentDays());
				ps.setInt(8, att.getAttendancePercentage());
				ps.addBatch();
				ps.execute();
				at.add(att);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return at;
	}

	public ArrayList<Attendance> viewAtStudentId(String id) {
		// TODO Auto-generated method stub
		ArrayList<Attendance> stdId = new ArrayList<>();
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM ATTENDANCE WHERE STUDENT_ID=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Attendance obj = new Attendance(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
				stdId.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return stdId;
	}

	public ArrayList<Attendance> viewAttUsingAttId(String id) {
		// TODO Auto-generated method stub
		ArrayList<Attendance> attId = new ArrayList<>();
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM ATTENDANCE WHERE ATTENDANCE_ID=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Attendance obj = new Attendance(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
				attId.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return attId;
	}

}
