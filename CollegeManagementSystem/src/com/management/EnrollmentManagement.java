package com.management;

import java.util.ArrayList;
import com.model.Enrollment;
import java.sql.*;

public class EnrollmentManagement {
	
//	DBConnectionManager db = new DBConnectionManager();
	Connection con = DBConnectionManager.getConnection();
	public ArrayList<Enrollment> addEnrollment(ArrayList<Enrollment> enrollObj) {
		// TODO Auto-generated method stub
		
		ArrayList<Enrollment> enrollList = new ArrayList<Enrollment>();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO ENROLLMENT (ENROLLMENT_ID,STUDENT_ID,COURSE_ID) VALUES (?,?,?)");
			for(Enrollment obj : enrollObj) {
				ps.setString(1, obj.getEnrollmentId());
				ps.setString(2, obj.getStudentId());
				ps.setString(3, obj.getCourseId());
				ps.addBatch();
				ps.execute();
				enrollList.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return enrollList;
	}

	public ArrayList<Enrollment> viewEnroll(String crsId) {
		// TODO Auto-generated method stub
		ArrayList<Enrollment> objList = new ArrayList<Enrollment>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ENROLLMENT WHERE COURSE_ID = ?");
			ps.setString(1,crsId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Enrollment obj = new Enrollment(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				objList.add(obj);     
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return objList;
	}

	public int deleteEnrollment(String enrId) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM ENROLLMENT WHERE ENROLLMENT_ID = ?");
			ps.setString(1, enrId);
			int num1 = ps.executeUpdate();
			return num1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public ArrayList<String> viewActualFees(String enId) {
		// TODO Auto-generated method stub
		ArrayList<String> feeList = new ArrayList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT s.student_name, e.enrollment_id, e.fee_status from student s natural join enrollment e "
					+ "where student_id = (SELECT STUDENT_ID FROM ENROLLMENT WHERE ENROLLMENT_ID = ?)");
			ps.setString(1, enId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String str = rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3);
				feeList.add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return feeList;
	}

}
