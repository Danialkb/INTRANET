package UsersDemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import users.Student;

public class StudentMenu {
	public static boolean checkStudent(Student s) {
		if(!s.isPassedQuestionary()) {
			System.out.println("Please rate Teachers!!!");
			return false;
		}
		return true;
			
	}
	
	public static void studentMenu(Student student) throws IOException {
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in)); 
		
		while(true) {
			String welcometoStudentPage = """
					1. View my courses
					2. View transcript
					3. Add/Drop
					4. Rate teachers
					5. Student's requests
					""";
			System.out.println(welcometoStudentPage);
			String input1 = reader1.readLine();
		
			switch(input1) {
				case "1":
					while(true) {
						String menuforStud = """
								1. View courses
								2. Exit to main menu
								""";
						System.out.println(menuforStud);
						input1 = reader1.readLine();
						
						if(input1.equals("1")) {
							student.viewCourses();
						} 
						else if(input1.equals("2")) {
							break; 
						}
					}
					
				case "2":
					while(true) {
						String menuforStud = """
								1. View transcript
								2. Exit to main menu
								""";
						System.out.println(menuforStud);
						input1 = reader1.readLine();
						
						if(input1.equals("1")) {
							student.viewTranscript();
						} else if(input1.equals("2")) {
							break; 
						}
					}
					
//				case "3":
//					while(true) {
//						String menuforStud = """
//								1. Add course
//								2. Drop course
//								3. Exit to main menu
//								""";
//						System.out.println(menuforStud);
//						input1 = reader1.readLine();
//						
//						if(input1.equals("1")) {
//							student.addCourse();
//						} else if(input1.equals("2")) {
//							student.dropCourse();
//						} else if(input1.equals("3")) {
//							break;
//						}
//					}
//				case "4":
//					while(true) {
//						String menuforStud = """
//								1. Rate teachers
//								2. Exit to main menu
//								""";
//						System.out.println(menuforStud);
//						input1 = reader1.readLine();
//						
//						if(input1.equals("1")) {
//							student.rateTeacher();
//						} else if(input1.equals("2")) {
//							break;
//						}
//					}
//				case "5":
//					while(true) {
//						String menuforStud = """
//								1. Add request
//								1. View requests
//								2. Exit to main menu
//								""";
//						System.out.println(menuforStud);
//						input1 = reader1.readLine();
//						
//						if(input1.equals("1")) {
//							student.viewRequest
//						}
//					}
			}
		}
	}
}