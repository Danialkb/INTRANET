package UsersDemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import coursecomponents.Course;
import enums.RequestType;
import handlers.Database;
import handlers.Request;
import users.Manager;
import users.Student;
import users.Teacher;

public class StudentMenu {
	public static boolean checkStudent(Student s) {
		if(!s.isPassedQuestionary()) {
			System.out.println("Please rate Teachers!!!");
			return false;
		}
		return true;
			
	}
	
	public static void studentMenu(Student student) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		while(true) {
			String welcometoStudentPage = """
					1. View my courses
					2. View transcript
					3. Add/Drop
					4. Rate teachers
					5. Student's requests
					6. View course files
					7. View Schedule
					8. Personal Info
					9. View news
					10. Log Out
					""";
			System.out.println(welcometoStudentPage);
			String input1 = br.readLine();
			if(input1.equals("10")) {
				break;
			}
			switch(input1) {
				case "1":
					String menuforStud = """
									1. View courses
									2. Back
									""";
					if(checkStudent(student)) {
						while(true) {
							System.out.println(menuforStud);
							String input2 = br.readLine();
							if(input2.equals("1")){
								if(student.getCourses().size() == 0) {
									System.out.println("No courses!");
								}
								else
									student.viewCourses();
							}
							else 
								break; 
						}
					}
					break;
					
				case "2":
					menuforStud = """
									1. View transcript
									2. Exit to main menu
									""";
					if(checkStudent(student)) {
						while(true) {
							System.out.println(menuforStud);
							input1 = br.readLine();
							
							if(input1.equals("1")) {
								student.viewTranscript();
							} else if(input1.equals("2")) {
								break; 
							}
						}
					}
					break;
					
				case "3":
					menuforStud = """
									1. Add course
									2. Drop course
									3. Exit to main menu
									""";
					if(checkStudent(student)) {
						while(true) {
							System.out.println(menuforStud);
							String input2 = br.readLine();
							
							if(input2.equals("1")) {
								System.out.println("Select course:");
								int i = 1;
								Vector<Course> v = new Vector<Course>();
								for(Course c: Database.getDB().getCourse()) {
									if(student.getCourses().get(c) == null) {
										System.out.println(i + ". " + c);
										i++;
										v.add(c);
									}
								}
								String toadd = br.readLine();
								if(Manager.approveRegistration(student, v.elementAt(toadd.charAt(0) - 49))) {
									student.addCourse(v.elementAt(toadd.charAt(0) - 49));
									System.out.println("Successfully registred!");
								}
								else {
									System.out.println("You have not passed prerequisite course!");
								}
								
							} 
							else if(input2.equals("2")) {
								System.out.println("Select course:");
								int i = 1;
								if(student.getCourses().size() == 0) {
									System.out.println("No courses!");
								}
								else {
									Vector<Course> v = new Vector<Course>();
									for(Course c: Database.getDB().getCourse()) {
										if(student.getCourses().get(c) != null) {
											System.out.println(i + ". " + c);
											i++;
											v.add(c);
										}
									}
									System.out.println("Enter q to go back");
									String todel = br.readLine();
									if(todel.equals("q"))
										continue;
									
									student.dropCourse(v.elementAt(todel.charAt(0) - 49));
									System.out.println("Successfully dropped!");
								}
							} 
							else if(input2.equals("3")) {
								break;
							}
						}
					}
					break;
					
				case "4":
					for(Teacher t: student.getTeachers()) {
						System.out.println("Enter rate 1-10 for reacher " + t.getFullName());
						String rate = br.readLine();
						student.rateTeacher(t, rate.charAt(0) - 48);
					}
					break;
				case "5":
					menuforStud = """
								1. Add request
								2. View requests
								3. Exit to main menu
								""";
					while(true) {
						System.out.println(menuforStud);
						String in = br.readLine();
						
						if(in.equals("1")) {
							RequestType[] ar = RequestType.values();
							System.out.println("Choose request:");
							for(int i = 0; i < ar.length; i++) {
								System.out.println((i + 1) + " " + ar[i]);
							}
							String choose = br.readLine();
							student.addRequest(new Request(ar[choose.charAt(0) - 49], student));
							System.out.println("Wait results!");
						}
						else if(in.equals("2")) {
							student.viewRequests();
						}
						else if(in.equals("3"))
							break;
					}
					break;
				case "6":
					System.out.println("Select course:");
					student.viewCourses();
					System.out.println("q to go back");
					String choose = br.readLine();
					if(choose.equals("q")) {
						continue;
					}
					Course[] myar = new Course[student.getCourses().keySet().size()];
					student.getCourses().keySet().toArray(myar);
					Course c = myar[choose.charAt(0) - 49];
					System.out.println("Select teacher:");
					Vector<Teacher> t = new Vector<Teacher>();
					int pos1 = 1;
					for(Teacher i: c.getFiles().keySet()) {
						if(i.getStudents(c).contains(student)) {
							System.out.println(pos1 + ". " + i.getFullName());
							t.add(i);
						}
					}
					System.out.println("q to go back");
					String choose2 = br.readLine();
					if(choose2.equals("q"))
						continue;
					student.viewCourseFiles(t.elementAt(choose2.charAt(0) - 49), c);
					break;
				
				case "7":
					student.viewSchedule();
					break;
					
				case "8":
					System.out.println(student);
					break;
				case "9":
					while(true) {
						student.viewNews();
						System.out.println("q to go back");
						String in = br.readLine();
						if(in.equals("q"))
							break;
						else {
							System.out.println(Database.getDB().getNews().elementAt(in.charAt(0) - 49).getDescribtion());
							System.out.println("Write something to go back");
							in = br.readLine();
						}
					}
					
			}
		}
	}
}