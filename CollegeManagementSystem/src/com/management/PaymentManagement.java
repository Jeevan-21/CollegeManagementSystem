package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Enrollment;

public class PaymentManagement {
	
	Connection con = DBConnectionManager.getConnection();

	public ArrayList<Enrollment> viewStudentDetails(String enrollId) {
		// TODO Auto-generated method stub
		ArrayList<Enrollment> enrollmentList = new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Enrollment where Enrollment_Id = ?");
			ps.setString(1, enrollId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Enrollment obj = new Enrollment(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				enrollmentList.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return enrollmentList;
	}

}
