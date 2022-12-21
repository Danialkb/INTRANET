package UsersDemo;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.nio.charset.CoderMalfunctionError;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.xml.crypto.Data;

import coursecomponents.Course;
import coursecomponents.Lesson;
import coursecomponents.TimeSlot;
import enums.CourseType;
import enums.Days;
import enums.FacultyNames;
import enums.JobTitle;
import enums.LessonType;
import enums.ManagerTitle;
import enums.StudentDegree;
import enums.TeacherType;
import handlers.Database;
import handlers.News;
import handlers.Speciality;
import users.Manager;
import users.Student;
import users.Teacher;
import users.User;

public class Menu {
	
	public static void main(String[] args) throws IOException{
		Speciality is = new Speciality("Information Systems", FacultyNames.SITE);
		Course c1 = new Course("OOP", "CSCI2105", 5, "some description", FacultyNames.SITE, 300, null, 0, CourseType.MANDATORY);
		Course c2 = new Course("ADS", "CSCI2106", 5, "some description", FacultyNames.SITE, 300, null, 0, CourseType.MANDATORY);
		Course c3 = new Course("Django", "CSCI2104", 5, "some description", FacultyNames.SITE, 300, "CSCI2112", 0, CourseType.MAJOR);
		Course c4 = new Course("Databases", "CSCI2110", 5, "some description", FacultyNames.SITE, 300, null, 0, CourseType.MANDATORY);
		Course c5 = new Course("Web Dev", "CSCI2112", 5, "some description", FacultyNames.SITE, 300, "CSCI2110", 0, CourseType.MANDATORY);
		
		Student s1 = new Student("123", "Togzhan Beldeubaeva", "21B031121", 2, StudentDegree.BACHELOR, FacultyNames.SITE, "87777826521", is);
		Student s2 = new Student("123", "Danial Bidaibek", "21B031193", 2, StudentDegree.BACHELOR, FacultyNames.SITE, "87779316622", is);
		Database.getDB().addUser(s1);
		Database.getDB().addUser(s2);
		Database.getDB().addCourse(c1);
		Database.getDB().addCourse(c2);
		Database.getDB().addCourse(c3);
		Database.getDB().addCourse(c4);
		Database.getDB().addCourse(c5);
		
//		c1.addFile(null, null);
		
		Teacher pakita = new Teacher("123", "Pakizar Shamoi", "6B3092", 1000000, JobTitle.TEACHER, TeacherType.PROFESSOR);
		
		HashMap<Course, Vector<Lesson>> sc = new HashMap<Course, Vector<Lesson>>();
		Vector<Lesson> l1 = new Vector<Lesson>();
		l1.add(new Lesson("461", LessonType.LECTURE, new TimeSlot(Days.MON, 14, 16), 100));
		l1.add(new Lesson("269", LessonType.PRACTICE, new TimeSlot(Days.TUE, 15, 16), 100));
		sc.put(c1, l1);
		Vector<Lesson> l2 = new Vector<Lesson>();
		l2.add(new Lesson("444", LessonType.LECTURE, new TimeSlot(Days.THU, 13, 15), 100));
		l2.add(new Lesson("257", LessonType.PRACTICE, new TimeSlot(Days.FRI, 14, 15), 100));
		sc.put(c2, l2);
		s1.setSchedule(sc);
		s2.setSchedule(sc);
		s1.addCourse(c1);
		s1.addCourse(c2);
		s2.addCourse(c2);
		s2.addCourse(c1);
		News n1 = new News("Some title", "Some description", new Date());
		News n2 = new News("Some title new", "Some description new", new Date());
		Database.getDB().addNews(n1);
		Database.getDB().addNews(n2);
//		System.out.println(pakita.getUsername());
		Database.getDB().addUser(pakita);
		Manager m = new Manager("123", "Valeriya Li", "6B03218", 300000, JobTitle.MANAGER, ManagerTitle.OR);
		Database.getDB().addUser(m);
		m.setCourseForTeacher(pakita, c1, l1);
		m.setCourseForTeacher(pakita, c2, l2);
		c1.getStudents().put(pakita, Database.getDB().getStudent());
		c2.getStudents().put(pakita, Database.getDB().getStudent());
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String welcomePage = """
                       1. Login
                       2. Exit 
                       """;
			while(true) {
				System.out.println(welcomePage);
				
				String input = reader.readLine();
				if(input.equals("1")) {
					
					System.out.print("\nUsername: ");
			        String username = reader.readLine();
			        
					User cur = Database.getDB().getUser(username);
					System.out.print("Password: ");
					String password = reader.readLine();
					
					if(cur == null) {
						System.out.println("No such user");
					}
					
					else if(!cur.logIn(username, password)) {
						System.out.println("Invalid password!");
					}
					else {
						System.out.println(cur.getFullName() + " scuccessfully logged in!");
						if (cur instanceof Student) {
							StudentMenu.studentMenu((Student)cur);
						}
						else if(cur instanceof Teacher) {
							TeacherDemo.TacherMenu((Teacher) cur);
						}
					}
				} 
				else if (input.equals("2")) {
					System.out.println("\nLog out of the system");
					break;
				}
			}
		} catch (IOException exception) {
            System.out.println("Exception");
        }
		
		Database.serialize();
		
	}	
}	