package com.client;
import com.model.Attendance;
import com.model.Course;
import com.model.Enrollment;
import com.model.Mark;
import com.model.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.service.StudentService;
import com.service.CourseService;
import com.service.EnrollmentService;
import com.service.AttendanceService;
import com.service.MarkService;
import com.service.PaymentService;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StudentService ss = new StudentService();
		CourseService cs = new CourseService();
		EnrollmentService es = new EnrollmentService();
		AttendanceService as = new AttendanceService();
		MarkService ms = new MarkService();
		PaymentService ps = new PaymentService();
		
		int choice;
		do {
			System.out.println("1. Student Module\n2. Course Module\n3. Enrollment Module\n4. Attendance Module\n"
					+ "5. Mark Module\n6. Payment Module\n7. Exit");
			choice = sc.nextInt();
			sc.nextLine();
			
		if(choice == 1) {
			
			int choice1 ;
			do {
				System.out.println("1. Add Student\n2. Update Student\n3. View Student\n"
						+ "4. Delete Student\n5. Go Back to Main Menu");
				choice1 = sc.nextInt();
				sc.nextLine();
				
				if(choice1 == 1) {
					System.out.println("Enter Number of Students to be Adding ?");
					int size = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter the Student Details as (AddmissonNo:"
							+ "Name:DOB:YearOfStudy:YearOfJoining:10thMark:12thMark:FirstGraduate"
							+ ":MailId:PhoneNumber)");
					
					String studArr[] = new String[size];
					for(int i=0;i<size;i++) {
						studArr[i] = sc.nextLine();
					}
					
					List<Student> obj = ss.addStudent(studArr);
					
					if(obj.isEmpty()) {
						
						System.out.println("No Data Added");
					}
					else
					{
						for(Student s:obj)
						{
							System.out.println(s.getStudentName()+" is added. Your Student Id is " + s.getStudentId());
						}
					}
				}
				
				if(choice1 == 2) {
					System.out.println("Enter Your Student Id Ex.(CRISP001)");
					String studId = sc.nextLine();
					System.out.println("Exist Phone Number");
					try {
						ArrayList<String> phone = ss.existPhoneNo(studId);
						System.out.println("Student Name = "+phone.get(0) +"\n Student Phone No = "+phone.get(1));
					
					System.out.println("Enter Your Correct Phone Number");
					long newNumber = sc.nextLong();
					sc.nextLine();
					
						int num = ss.updatePhoneNumber(studId,newNumber);
						if(num>0) {
							System.out.println(num + " row updated.");
						}else {
							System.out.println("Your Phone Number cannot Updated.");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
				}
				
				if(choice1 == 3) {
					int ch;
					do {
						System.out.println("View Student Details based on \n1. Student Id\n2. Year of Study\n3. Exit");
						ch = sc.nextInt();
						sc.nextLine();
						if(ch == 1) {
							System.out.println("Enter Student Id Ex.(CRISP001)");
							String stdId = sc.nextLine();
							try {
								ArrayList<Student> studLs = ss.viewUsingStudentId(stdId);
								if(studLs.isEmpty()) {
									System.out.println(stdId + "Student is Not Available.");	
								}
								for(Student s:studLs) {
									System.out.println("ADMISSION NUMBER  = " + s.getAdmissionNumber());
									System.out.println("STUDENT ID        = " + s.getStudentId());
									System.out.println("STUDENT NAME      = " + s.getStudentName());
									System.out.println("DOB               = " + s.getDob());
									System.out.println("YEAR OF STUDY     = " + s.getYearOfStudy());
									System.out.println("YEAR OF JOINING   = " + s.getYearOfJoining());
									System.out.println("TENTH GRADE MARK  = " + s.getTenthGradeMark());
									System.out.println("TWLTH GRADE MARK  = " + s.getTwelthGradeMark());
									System.out.println("FIRST GRADUATE    = " + s.getFirstGraduate());
									System.out.println("EMAIL ID          = " + s.getEmailId());
									System.out.println("PHONE NUMBER      = " + s.getPhoneNumber());
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						if(ch == 2) {
							System.out.println("Enter Year of Study Ex. 1st Year give ( 1 ) ");
							int yos=sc.nextInt();
							sc.nextLine();
							try {
								ArrayList<Student> stud = new ArrayList<>();
								stud = ss.viewStudent(yos);
								if(stud.isEmpty()) {
									System.out.println("No Students Available for "+yos+" Year.");	
								}
								else {
									System.out.printf("|-----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------------------------------------|%n");
									System.out.printf("| %-20s | %-10s | %-20s | %-10s | %-15s | %-15s | %-20s | %-20s | %-15s | %-20s | %-15s |%n",
											"ADMISSION NUMBER","STUDENT ID","STUDENT NAME","DOB","YEAR OF STUDY","YEAR OF JOINING","TENTH GRADE MARK",
											"TWELTH GRADE MARK","FIRST GRADUATE","EMAIL ID","PHONE NUMBER");
									System.out.printf("|-----------------------------------------------------------------------------------------"
											+ "---------------------------------------------------------------------------------------------------------------------------|%n");
									for(Student s:stud) {
										System.out.printf("|     %-16s | %-10s | %-20s | %-10s |      %-10s | %-15s | %-20s | %-20s | %-15s | %-20s | %-15s |%n",
												s.getAdmissionNumber(),s.getStudentId(),s.getStudentName(),s.getDob(),s.getYearOfStudy(),s.getYearOfJoining(),
												s.getTenthGradeMark(),s.getTwelthGradeMark(),s.getFirstGraduate(),s.getEmailId(),s.getPhoneNumber());
										System.out.printf("|------------------------------------------------------------------------------------------"
												+ "--------------------------------------------------------------------------------------------------------------------------|%n");
									}
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
						}
						
						if(ch == 3) {
							break;
						}
					
					} while (ch != 3);
				}
				
				if(choice1 == 4) {	
					System.out.println("Enter Student Id ");
					String stdId = sc.nextLine();
					try {
						int num1 = ss.deleteStudent(stdId);
						if(num1>0) {
							System.out.println(num1 + " details Deleted Succesfully.");
						}
						else {
							System.out.println(stdId + " cannot Delete this Student Detail.");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				
				if(choice1 == 5) {
					break;
				}
				
			}
			while(choice1 != 5);	
		}
		
		if(choice == 2) {
			int choice2;
			do {
				System.out.println("1. Add Course\n2. Update Course\n3. View Course\n4. Delete Course\n5. Go Back to Main Menu");
				choice2 = sc.nextInt();
				sc.nextLine();
				
				if(choice2 == 1) {
					System.out.println("Enter Number of Course to be Added ?");
					int size = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter Course Details (CourseId:CourseName:CourseCoordinator:Department:CourseFee) like this format");
					String arr[] = new String[size];
					
					for(int i=0;i<size;i++) {
						arr[i] = sc.nextLine();
					}
					
					ArrayList<Course> addedCourse = cs.addCourse(arr);
					if(addedCourse.isEmpty()) {
						System.out.println("No Courses is Added.");
					}
					else {
						for(Course obj:addedCourse) {
							System.out.println(obj.getCourseName()+" is Added. Course Id is "+obj.getCourseId());
						}
					}
				}
				
				if(choice2 == 2) {
					System.out.println("Enter Course Id Ex.(CRS001)");
					String courseId = sc.nextLine();
					System.out.println("Enter Updated Course Fee");
					double courseFee = sc.nextDouble();
					sc.nextLine();
					try {
						int num = cs.updateCourse(courseId,courseFee);
						if(num>0) {
							System.out.println(num + " rows is Updated.");
						}else {
							System.out.println("Cannot Update the Course Fee.");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				
				if(choice2 == 3) {
					System.out.println("Enter the Course ID Ex.(CRS001)");
					String courseId1 = sc.nextLine();
					
					try {
						ArrayList<String> ls = cs.viewCourse(courseId1);
						if(ls.isEmpty()) {
							System.out.println("No Course Details Available in this "+ courseId1);
						}else {
							System.out.printf("|-----------------------------------------------------------------------------------------|%n");
							System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-15s |%n","CourseId","CourseName","CourseCoordinator","Department","CourseFee");
							System.out.printf("|-----------------------------------------------------------------------------------------|%n");
							for(String str1 : ls) {
								String str[] = str1.split(":");
								System.out.printf("| %-10s | %-15s | %-20s | %-15s | %-15s |%n",str[0],str[1],str[2],str[3],str[4]);
								System.out.printf("|-----------------------------------------------------------------------------------------|%n");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				
				if(choice2 == 4) {
					System.out.println("Enter the Course ID");
					String CourseId2 = sc.nextLine();
					
					try {
						int num1 = cs.deleteCourse(CourseId2);
						if(num1>0)
							System.out.println(num1 + " courses Deleted.");
						else
							System.out.println("No Courses Deleted.");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				
				if(choice == 5) {
					break;
				}
				
			} while (choice2 != 5);
		}
		
		if(choice == 3) {
			int choice3;
			do {
				System.out.println("1. Enrollment Registration\n2. View Fee Status\n3. View Enrollment\n4. Delete Enrollment\n5. Go Back to Main Menu");
				choice3 = sc.nextInt();
				sc.nextLine();
				
				if(choice3 == 1) {
					System.out.println("Enter Number of Enrollment Registration");
					int size = sc.nextInt();
					sc.nextLine();
					String arr[] = new String[size];
					System.out.println("Enter Details(Enrollment Id : Student Id : course Id)");
					for(int i=0;i<size;i++) {
						arr[i] = sc.nextLine();
					}
					ArrayList<Enrollment> enroll = es.addEnrollment(arr);
					if(enroll.isEmpty()) {
						System.out.println("No Enrollment Details Added.");
					}else {
						for(Enrollment obj:enroll) {
							System.out.println(obj.getEnrollmentId() +" is Added.");
						}
					}
				}
				
				if(choice3 == 2) {
					System.out.println("Enter Enrollment Id. Ex(ERID001)");
					String enId = sc.nextLine();
					ArrayList<String> feeList = es.viewActualFee(enId);
					if(feeList.isEmpty()) {
						System.out.println(enId +" Fees Details Not Available.");
					}else {
						for(String obj : feeList) {
							String arr[] = obj.split(":");
							System.out.println("Student Name : "+arr[0]+"\nEnrollment Id : "+arr[1]+"\nFee Status : "+arr[2]);
						}
					}
				}
				
				if(choice3 == 3) {
					System.out.println("Enter Course Id. Ex(CRS001)");
					String crsId = sc.nextLine();
					ArrayList<Enrollment> objectList = es.viewEnroll(crsId);
					if(objectList.isEmpty()) {
						System.out.println(crsId + " this Course Id is not Available");
					}else {
						System.out.printf("~--------------------------------------------------------~%n");
						System.out.printf("| %-15s | %-10s | %-10s | %-10s |%n","ENROLLMENT_ID","STUDENT_ID","COURSE_ID","FEE_STATUS");
						System.out.printf("|--------------------------------------------------------|%n");
						for(Enrollment obj : objectList) {
							System.out.printf("| %-15s | %-10s | %-10s | %-10s |%n",obj.getEnrollmentId(),obj.getStudentId(),obj.getCourseId(),obj.getFeesStatus());
							System.out.printf("~--------------------------------------------------------~%n");
						}
					}
				}
				
				if(choice3 == 4) {
					System.out.println("Enter Enrollment Id");
					String enrId = sc.nextLine();
					int num1 = es.deleteEnrollment(enrId);
					if(num1>0) {
						System.out.println(enrId + " is Deleted.");
					}else {
						System.out.println("No rows Deleted.");
					}
				}
				
			} while (choice3 != 5);
		} 
		
		if(choice == 4) {
			int choice4;
			do {
				System.out.println("1. Add Attendance List\n2. Retreive Attendance Record\n3. Goto Main Menu");
				choice4 = sc.nextInt();
				sc.nextLine();
				
				if(choice4 == 1) {
					System.out.println("Enter Number of Attendance List to be Added ?");
					int size = sc.nextInt();
					sc.nextLine();
					
					String arr[] = new String[size]; 
					System.out.println("Enter (Attendance Id : Student Id : Enrollment Id : Semester : Total Working Days : Present Days");
					for(int i=0;i<size;i++) {
						arr[i] = sc.nextLine();
					}
					
					ArrayList<Attendance> attList = as.addAttendance(arr);
					if(attList.isEmpty()) {
						System.out.println("Cannot added attendance List.");
					}else {
						System.out.println(attList.size() + " rows are added.");
					}
				}
				
				if(choice4 == 2) {
					int ch;
					do {
						System.out.println("1. View Attendance Record based on Student_Id\n2. View Attendance Record based on Attendance_Id\n3. Go Back");
						ch = sc.nextInt();
						sc.nextLine();
						
						if(ch == 1) {
							System.out.println("Enter Student_Id Ex.(CRISP001)");
							String stdId = sc.nextLine();
							ArrayList<Attendance> atList1 = as.viewUsingStudentId(stdId);
							if(atList1.isEmpty()) {
								System.out.println("No Attendance Details Available in this "+stdId+" Student Id");
							}else {
								for(Attendance obj:atList1) {
									System.out.println("Attendance Id = " +obj.getAttendanceId());
									System.out.println("Student Id = " + obj.getStudentId());
									System.out.println("Enrollment Id = " + obj.getEnrollmentId());
									System.out.println("Semester = " + obj.getSemester());
									System.out.println("Total Working Days = " + obj.getTotalWorkingDays());
									System.out.println("Present Days = " + obj.getPresentDays());
									System.out.println("Absent Days = " + obj.getAbsentDays());
									System.out.println("Attendance Percentage = " + obj.getAttendancePercentage());
								}
							}
						}
						if(ch == 2) {
							System.out.println("Enter Attendance_Id Ex.(ATID001)");
							String atId = sc.nextLine();
							ArrayList<Attendance> atList2 = as.viewUsingAttId(atId);
							if(atList2.isEmpty()) {
								System.out.println("No Attendance Details Available in this "+atId+" Attendance Id");
							}else {
								for(Attendance obj:atList2) {
									System.out.println("Attendance Id = " +obj.getAttendanceId());
									System.out.println("Student Id = " + obj.getStudentId());
									System.out.println("Enrollment Id = " + obj.getEnrollmentId());
									System.out.println("Semester = " + obj.getSemester());
									System.out.println("Total Working Days = " + obj.getTotalWorkingDays());
									System.out.println("Present Days = " + obj.getPresentDays());
									System.out.println("Absent Days = " + obj.getAbsentDays());
									System.out.println("Attendance Percentage = " + obj.getAttendancePercentage());
								}
							}
						}
						if(ch == 3) {
							break;
						}
						
					} while (ch != 3);
				}
				
				if(choice4==3) {
					break;
				}
				
			} while (choice4 != 4);
		}
		
		if(choice == 5) {
			int choice5;
			do {
				System.out.println("1. Add Mark List\n2. View Mark List\n3. Go Back to Main Menu");
				choice5 = sc.nextInt();
				sc.nextLine();
				
				if(choice5 == 1) {
					System.out.println("Enter Number of Student Marks List Added ? ");
					int size = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter Mark Details as (Mark Id : Student Id : Semester : Subject1 : Subject2 : Subject3 : Subject4 :"
							+ "Subject5 : Subject6 : Subject7 : Subject8)");
					
					String arr[] = new String[size];
					
					for(int i=0;i<size;i++) {
						arr[i] = sc.nextLine();
					}
					ArrayList<Mark> markList = ms.addMarks(arr);
					if(markList.isEmpty()) {
						System.out.println("No Student Marks Added.");
					}else {
					    System.out.println(markList.size() + " Mark details added successfully.");
					}
				}
				
				if(choice5 == 2) {
					int ch;
					do {
						System.out.println("View Mark List based on\n1. Student Id\n2. Semester\n3. Exit");
						ch = sc.nextInt();
						sc.nextLine();
						
						if(ch == 1) {
							System.out.println("Enter the Student Id Ex.(CRISP001)");
							String studId = sc.nextLine();
							
							ArrayList<Mark> markListUsingStudId = ms.viewMarkListusingStudentId(studId);
							if(markListUsingStudId.isEmpty()) {
								System.out.println(studId + " this Student Mark Details Not Available.");
							}else {
								for(Mark obj:markListUsingStudId) {
									String markId = obj.getMarkId();
									String stdId = obj.getStudentId();
									int sem = obj.getSemester();
									String sub1 = obj.getSubject1();
									String sub2 = obj.getSubject2();
									String sub3 = obj.getSubject3(); 
									String sub4 = obj.getSubject4();
									String sub5 = obj.getSubject5();
									String sub6 = obj.getSubject6();
									String sub7 = obj.getSubject7();
									String sub8 = obj.getSubject8();
									double gpa = obj.getGpa();
									double cgpa = obj.getCgpa();
									
									System.out.printf("~-----------------------------------------------------------------------------------------------------------------"
											+ "----------------------------------------------------------------------------------------------------------------------------------"
											+ "-----------------~%n");
									System.out.printf("| %-9s| %-10s | %-9s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|  %-6s|  %-6s|%n"
											+ "","MARK_ID","STUDENT_ID","SEMESTER","SUBJECT 1","SUBJECT 2","SUBJECT 3","SUBJECT 4","SUBJECT 5","SUBJECT 6"
													+ "","SUBJECT 7","SUBJECT 8","GPA","CGPA");
									System.out.printf("|----------|------------|----------|-------------------------|-------------------------|-------------------------|"
											+ "-------------------------|-------------------------|-------------------------|-------------------------|-------------------------|"
											+ "--------|--------|%n");
									System.out.printf("| %-9s| %-10s |    %-6d| %-24s| %-24s| %-24s| %-24s| %-24s| %-24s| %-24s| %-24s| %.2f  |  %.2f  |%n",
											markId,stdId,sem,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,gpa,cgpa);
									System.out.printf("|----------|------------|----------|-------------------------|-------------------------|-------------------------|"
											+ "-------------------------|-------------------------|-------------------------|-------------------------|-------------------------|"
											+ "--------|--------|%n");
								}
							}
						}
						
						if(ch == 2) {
							System.out.println("Enter the Semester Ex.(1)");
							int semester = sc.nextInt();
							sc.nextLine();
							
							ArrayList<Mark> markListUsingSemester = ms.viewMarkListusingSemester(semester);
							
							if(markListUsingSemester.isEmpty()) {
								System.out.println(semester + "th Semester Mark Details Not Available.");
							}else {

								for(Mark obj:markListUsingSemester) {
									String markId = obj.getMarkId();
									String stdId = obj.getStudentId();
									int sem = obj.getSemester();
									String sub1 = obj.getSubject1();
									String sub2 = obj.getSubject2();
									String sub3 = obj.getSubject3(); 
									String sub4 = obj.getSubject4();
									String sub5 = obj.getSubject5();
									String sub6 = obj.getSubject6();
									String sub7 = obj.getSubject7();
									String sub8 = obj.getSubject8();
									double gpa = obj.getGpa();
									double cgpa = obj.getCgpa();
									
									System.out.printf("~-----------------------------------------------------------------------------------------------------------------"
											+ "----------------------------------------------------------------------------------------------------------------------------------"
											+ "-----------------~%n");
									System.out.printf("| %-9s| %-10s | %-9s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|     %-20s|  %-6s|  %-6s|%n"
											+ "","MARK_ID","STUDENT_ID","SEMESTER","SUBJECT 1","SUBJECT 2","SUBJECT 3","SUBJECT 4","SUBJECT 5","SUBJECT 6"
													+ "","SUBJECT 7","SUBJECT 8","GPA","CGPA");
									System.out.printf("|----------|------------|----------|-------------------------|-------------------------|-------------------------|"
											+ "-------------------------|-------------------------|-------------------------|-------------------------|-------------------------|"
											+ "--------|--------|%n");
									System.out.printf("| %-9s| %-10s |    %-6d| %-24s| %-24s| %-24s| %-24s| %-24s| %-24s| %-24s| %-24s| %.2f  |  %.2f  |%n",
											markId,stdId,sem,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,gpa,cgpa);
									System.out.printf("|----------|------------|----------|-------------------------|-------------------------|-------------------------|"
											+ "-------------------------|-------------------------|-------------------------|-------------------------|-------------------------|"
											+ "--------|--------|%n");
								}
							}
						}
						
						if(ch == 3) {
							break;
						}
						
					} while (ch != 3);
				}
				
				if(choice5 == 3) {
					break;
				}
				
			} while (choice5 != 3);
		}
		
		if(choice==6) {
			int choice6;
			do {
				System.out.println("1. Make Payment\n2. Retrieve Payment Record\n3. Back to main menu ");
				choice6 = sc.nextInt();
				sc.nextLine();
				
				if(choice6 == 1) {
					int ch;
					do {
					System.out.println("1. View Student Enrollment Details\n2. Calculate Bill Amount\n3. Made Payment\n4. Exit");
					ch = sc.nextInt();
					sc.nextLine();
					
					if(ch == 1) {
						System.out.println("Enter the Student EnrollmentId Ex.(ERID001)");
						String enrollId = sc.nextLine();
						  ArrayList<Enrollment> enrollmentList = ps.viewStudentDetails(enrollId);
						  if(enrollmentList.isEmpty()) {
							  System.out.println("No Enrolled Students Available.");
						  }else {
							  System.out.printf("~--------------------------------------------------------~%n");
								System.out.printf("| %-15s | %-10s | %-10s | %-10s |%n","ENROLLMENT_ID","STUDENT_ID","COURSE_ID","FEE_STATUS");
								System.out.printf("|--------------------------------------------------------|%n");
								for(Enrollment obj : enrollmentList) {
									System.out.printf("| %-15s | %-10s | %-10s | %-10s |%n",obj.getEnrollmentId(),obj.getStudentId(),obj.getCourseId(),obj.getFeesStatus());
									System.out.printf("~--------------------------------------------------------~%n");
								}
						  }
					}
					
//					if(ch == 2) {
//						System.out.println("Enter the Student EnrollmentId Ex.(ERID01)");
//						String enrollmentId = sc.nextLine();
//						
//						calculateBillAmount();
//					}
					} while (ch!=3);
				}
				
			}while(choice6!=3);
		}
		
		if(choice == 7) {
			System.out.println("Thanks for Using this application..!");
			break;
		}
		
		} while (choice != 7);
		sc.close();
	}
}
