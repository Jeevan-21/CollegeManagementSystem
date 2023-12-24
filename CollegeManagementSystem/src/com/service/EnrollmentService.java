package com.service;

import java.util.ArrayList;
import com.model.Enrollment;
import com.util.ApplicationUtil;
import com.management.EnrollmentManagement;
public class EnrollmentService {
	
	EnrollmentManagement em = new EnrollmentManagement();
	
	public ArrayList<Enrollment> addEnrollment(String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<String> enrollList = ApplicationUtil.extractEnrollment(arr);
		ArrayList<Enrollment> enrollObj = buildEnrollment(enrollList);
		ArrayList<Enrollment> enList = em.addEnrollment(enrollObj);
		return enList;
	}

	private ArrayList<Enrollment> buildEnrollment(ArrayList<String> enrollList) {
		// TODO Auto-generated method stub
		ArrayList<Enrollment> enrollObj = new ArrayList<Enrollment>();
		for(String str:enrollList) {
			String s[] = str.split(":");
			String enrollmentId = s[0];
			String studentId = s[1];
			String courseId = s[2];
			Enrollment obj = new Enrollment(enrollmentId,studentId,courseId);
			enrollObj.add(obj);
		}
		return enrollObj;
	}

	public ArrayList<Enrollment> viewEnroll(String crsId) {
		// TODO Auto-generated method stub
		ArrayList<Enrollment>  objectList = em.viewEnroll(crsId);
		return objectList;
	}

	public int deleteEnrollment(String enrId) {
		// TODO Auto-generated method stub
		int num1 = em.deleteEnrollment(enrId);
		return num1;
	}

	public ArrayList<String> viewActualFee(String enId) {
		// TODO Auto-generated method stub
		ArrayList<String> fee_status = em.viewActualFees(enId);
		return fee_status;
	}

}
