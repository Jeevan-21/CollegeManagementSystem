package com.service;

import java.util.ArrayList;
import com.model.Attendance;
import com.util.ApplicationUtil;
import com.management.AttendanceManagement;

public class AttendanceService {
	
	AttendanceManagement am = new AttendanceManagement();
	
	public ArrayList<Attendance> addAttendance(String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<String> atndListString = ApplicationUtil.extractAttendance(arr);
		ArrayList<Attendance> attendanceObj = buildAttendance(atndListString);
		ArrayList<Attendance> attManageList = am.insertAttendance(attendanceObj);
		return attManageList;
	}

	private ArrayList<Attendance> buildAttendance(ArrayList<String> atndListString) {
		// TODO Auto-generated method stub
		ArrayList<Attendance> atndsObj = new ArrayList<>();
		for(String str : atndListString) {
			String arr[] = str.split(":");
			String atndsId = arr[0];
			String stndId = arr[1];
			String enrolId = arr[2];
			int semester = Integer.parseInt(arr[3]);
			int totlWorkDays = Integer.parseInt(arr[4]);
			int prsntDays = Integer.parseInt(arr[5]);
			int absDays = totlWorkDays - prsntDays;
			float total = ((float)prsntDays / totlWorkDays) * 100;
			int atndPercentage = (int)total;
			Attendance obj = new Attendance(atndsId,stndId,enrolId,semester,totlWorkDays,prsntDays,absDays,atndPercentage);
			atndsObj.add(obj);
		}
		return atndsObj;
	}

	public ArrayList<Attendance> viewUsingStudentId(String id) {
		// TODO Auto-generated method stub
		ArrayList<Attendance> atList1 = am.viewAtStudentId(id);
		return atList1;
	}

	public ArrayList<Attendance> viewUsingAttId(String id) {
		// TODO Auto-generated method stub
		ArrayList<Attendance> atList2 = am.viewAttUsingAttId(id);
		return atList2;
	}

}
