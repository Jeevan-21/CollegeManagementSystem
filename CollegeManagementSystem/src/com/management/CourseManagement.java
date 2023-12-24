package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.model.Course;

public class CourseManagement {
	
	DBConnectionManager db = new DBConnectionManager();

	public ArrayList<Course> addCourse(ArrayList<Course> courseObj) {
		// TODO Auto-generated method stub
		ArrayList<Course> courseList = new ArrayList<Course>();
		try {
			Connection con = DBConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO COURSE VALUES (?,?,?,?,?)");
			for(Course obj:courseObj) {
				ps.setString(1, obj.getCourseId());
				ps.setString(2, obj.getCourseName());
				ps.setString(3, obj.getCourseCoordinator());
				ps.setString(4, obj.getDepartment());
				ps.setDouble(5, obj.getCourseFee());
				ps.addBatch();
				ps.execute();
				courseList.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return courseList;
	}

	public int updateCourse(String courseId, double courseFee) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("update Course set course_fee=? where course_id=?");
		ps.setDouble(1, courseFee);
		ps.setString(2, courseId);
		
		int num = ps.executeUpdate();
		return num;
	}

	public ArrayList<String> viewCourse(String courseId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Course where course_id = ?");
		ps.setString(1, courseId);
		ResultSet rs = ps.executeQuery();
		String str="";
		ArrayList<String> list = new ArrayList<String>();
		while(rs.next()) {
			str = rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4)+":"+rs.getDouble(5);
			list.add(str);
		}
		return list;
	}

	public int deleteCourse(String courseId2) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from Course where course_id=?");
		ps.setString(1, courseId2);
		int num1 = ps.executeUpdate();
		return num1;
	}

	
}
