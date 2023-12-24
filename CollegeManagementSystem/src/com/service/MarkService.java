package com.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.management.MarkManagement;
import com.model.Mark;
import com.util.ApplicationUtil;

public class MarkService {
	MarkManagement mm = new MarkManagement();

	public ArrayList<Mark> addMarks(String[] arr) {
		// TODO Auto-generated method stub
		ArrayList<String> markList = ApplicationUtil.extractMarkDetails(arr);
		ArrayList<Mark> markObj = buildMarkList(markList);
		return mm.addMarkList(markObj);
	}

	private ArrayList<Mark> buildMarkList(ArrayList<String> markList) {
		// TODO Auto-generated method stub
		ArrayList<Mark> markObj = new ArrayList<>();
		for(String mark:markList) {
			String arr[] = mark.split(":");
			
			String markId = arr[0];
			String studentId = arr[1];
			int semester = Integer.parseInt(arr[2]);
			String sub1 = arr[3];
			String sub2 = arr[4]; 
			String sub3 = arr[5];
			String sub4 = arr[6];
			String sub5 = arr[7];
			String sub6 = arr[8];
			String sub7 = arr[9];
			String sub8 = arr[10];
			
			int sum = 0;
			for(int i=2;i<9;i++) {
				Pattern pattern = Pattern.compile("(\\d+)");
		        Matcher matcher = pattern.matcher(arr[i]);

		        while (matcher.find()) {
		            String str1 = matcher.group();
		            sum += Integer.parseInt(str1);
		        }
			}
			double gpa = sum / 8;
			
			if(semester == 1) {
				double cgpa = gpa/10;
				Mark obj = new Mark(markId,studentId,semester,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,gpa,cgpa);
//				System.out.println(markId+" "+studentId+" "+semester+" "+sub1+" "+sub2+" "+sub3+" "+sub4+" "+sub5+" "+sub6+" "+sub7+" "+sub8+" "+gpa+" "+cgpa);
				markObj.add(obj);
			}else {
				ArrayList<Double> sumgpa = calculateCGPA(studentId);
				double gpaCount = sumgpa.get(0);
				gpaCount += 1;
				double gpaSum = sumgpa.get(1);
				gpaSum += gpa;
				double cgpa1 = gpaSum / gpaCount;
				cgpa1 = cgpa1/10;
				Mark obj = new Mark(markId,studentId,semester,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,gpa,cgpa1);
				markObj.add(obj);
			}
		}
		return markObj;
	}

	private ArrayList<Double> calculateCGPA(String studentId) {
		// TODO Auto-generated method stub
		return mm.calculateCGPAusingStudentId(studentId);
	}

	public ArrayList<Mark> viewMarkListusingStudentId(String studId) {
		// TODO Auto-generated method stub
		return mm.viewMarkListusingStudentId(studId);
	}

	public ArrayList<Mark> viewMarkListusingSemester(int semester) {
		// TODO Auto-generated method stub
		return mm.viewMarkListUsingSemester(semester);
	}
	


}
