package com.service;

import java.util.ArrayList;

import com.management.PaymentManagement;
import com.model.Enrollment;

public class PaymentService {
	
	PaymentManagement pm = new PaymentManagement();

	public ArrayList<Enrollment> viewStudentDetails(String enrollId) {
		// TODO Auto-generated method stub
		return pm.viewStudentDetails(enrollId);
	}

}
