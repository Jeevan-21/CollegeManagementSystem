package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Mark;

public class MarkManagement {

	Connection con = DBConnectionManager.getConnection();
	public ArrayList<Double> calculateCGPAusingStudentId(String studentId) {
		// TODO Auto-generated method stub
		ArrayList<Double> mark = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select count(STUDENT_ID),sum(GPA) from Mark where student_id = ? group by student_id,gpa");
			ps.setString(1, studentId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				double count = rs.getDouble(1);
				mark.add(count);
				double gpasum = rs.getDouble(2);
				mark.add(gpasum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return mark;
	}
	public ArrayList<Mark> addMarkList(ArrayList<Mark> markList) {
		// TODO Auto-generated method stub
		ArrayList<Mark> addmarkObj = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("insert into Mark values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for(Mark obj:markList) {
				ps.setString(1,obj.getMarkId());
				ps.setString(2,obj.getStudentId());
				ps.setInt(3,obj.getSemester());
				ps.setString(4, obj.getSubject1());
				ps.setString(5, obj.getSubject2());
				ps.setString(6, obj.getSubject3());
				ps.setString(7, obj.getSubject4());
				ps.setString(8, obj.getSubject5());
				ps.setString(9, obj.getSubject6());
				ps.setString(10, obj.getSubject7());
				ps.setString(11, obj.getSubject8());
				ps.setDouble(12, obj.getGpa());
				ps.setDouble(13, obj.getCgpa());
				ps.addBatch();
				ps.executeUpdate();
				addmarkObj.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return addmarkObj;
	}
	public ArrayList<Mark> viewMarkListusingStudentId(String studId) {
		// TODO Auto-generated method stub
		ArrayList<Mark> markListBasedStudId = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Mark where Student_Id = ?");
			ps.setString(1, studId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Mark obj = new Mark(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDouble(12),rs.getDouble(13));
				markListBasedStudId.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return markListBasedStudId;
	}
	public ArrayList<Mark> viewMarkListUsingSemester(int semester) {
		// TODO Auto-generated method stub
		ArrayList<Mark> markListBasedSemester = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Mark where Semester = ?");
			ps.setInt(1, semester);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Mark obj = new Mark(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDouble(12),rs.getDouble(13));
				markListBasedSemester.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return markListBasedSemester;
	}

}
