package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.management.CourseManagement;
import com.model.Course;
import com.util.ApplicationUtil;
public class CourseService {
	
	CourseManagement cm = new CourseManagement();
	
	public ArrayList<Course> addCourse(String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<String> courseList = ApplicationUtil.extractCourseDetails(arr);
		ArrayList<Course> courseObj = buildCourse(courseList);
		ArrayList<Course> courses = cm.addCourse(courseObj);
		
		return courses;
	}

	private ArrayList<Course> buildCourse(ArrayList<String> courseList) {
		// TODO Auto-generated method stub
		ArrayList<Course> courseObj = new ArrayList<Course>();
		for(String str:courseList) {
			String arr[] = str.split(":");
			String courseId = arr[0];
			String courseName = arr[1];
			String courseCoordinator = arr[2];
			String department = arr[3];
			double courseFee = Double.parseDouble(arr[4]);
			Course obj = new Course(courseId,courseName,courseCoordinator,department,courseFee);
			courseObj.add(obj);
		}
		return courseObj;
	}

	public int updateCourse(String courseId, double courseFee) throws SQLException {
		// TODO Auto-generated method stub
		int num = cm.updateCourse(courseId,courseFee);
		return num;
	}

	public ArrayList<String> viewCourse(String courseId) throws SQLException {
		// TODO Auto-generated method stub
		return  cm.viewCourse(courseId);
		
	}

	public int deleteCourse(String courseId2) throws SQLException {
		// TODO Auto-generated method stub
		int num = cm.deleteCourse(courseId2);
		return num;
	}

}
