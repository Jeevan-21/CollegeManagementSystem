package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ApplicationUtil {
		
	public static ArrayList<String> extractDetails(String[] input){
		ArrayList<String> studentRecord = new ArrayList<String>();
		for(String student:input) {
			studentRecord.add(student);
		}
		return studentRecord;
	}
	public java.sql.Date ChangeDate(String dob) 
	{
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat("dd/mm/yyyy",java.util.Locale.getDefault()).parse(dob);
		} catch (ParseException e) {
 			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}
	public static ArrayList<String> extractCourseDetails(String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<String> courseRecord = new ArrayList<String>();
		for(String course:arr) {
			courseRecord.add(course);
		}
		return courseRecord;
	}
	public static ArrayList<String> extractEnrollment(String[] input) {
		// TODO Auto-generated method stub
		ArrayList<String> enrollmentRecord = new ArrayList<String>();
		for(String str:input) {
			enrollmentRecord.add(str);
		}
		return enrollmentRecord;
	}
	public static ArrayList<String> extractAttendance(String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<String> atndListString = new ArrayList<String>();
		for(String attendance:arr) {
			atndListString.add(attendance);
		}
		return atndListString;
	}
	public static ArrayList<String> extractMarkDetails(String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<String> markList = new ArrayList<>();
		for(String mark:arr) {
			markList.add(mark);
		}
		return markList;
	}
}
