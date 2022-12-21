package UsersDemo;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Vector;

import coursecomponents.Course;
import coursecomponents.File;
import enums.MarkType;
import handlers.Database;
import users.Employee;
import users.Student;
import users.Teacher;

public class TeacherDemo {
	public static void TacherMenu(Teacher t) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		while(true) {
			String welcometoStudentPage = """
					1. View my courses
					2. View course files
					3. View Schedule
					4. Personal Info
					5. View news
					6. Put Mark
					7. View Messages
					8. View Sent Messages
					9. Send Message
					10. Log Out
					""";
			System.out.println(welcometoStudentPage);
			String input1 = br.readLine();
			if(input1.equals("10"))
				break;
			switch(input1) {
			case "1":
				t.viewCourses();
				break;
			case "2":
				String menucourse = """
						1. Add File
						2. View File
						3. Exit to main page
						""";
				while(true) {
					System.out.println(menucourse);
					String in = br.readLine();
					if(in.equals("3"))break;
					
					System.out.println("Select course:");
					t.viewCourses();
					String choose = br.readLine();
					if(choose.equals("q"))
						break;
					Course[] myar = new Course[t.getSchedule().keySet().size()];
					t.getSchedule().keySet().toArray(myar);
					Course c = myar[Integer.parseInt(choose) - 1];
					if(in.equals("1")) {
						c.addFile(t, new File("Syllabus", new Date(), "some text", "pdf"));
					}
					else
						if(c.getFiles().get(t) == null) {
							System.out.println("No files");
							break;
						}
						t.viewCourseFiles(c);
				}
				break;
			case "3":
				t.viewSchedule();
				break;
			case "4":
				System.out.println(t);
				break;
			case "5":
				while(true) {
					t.viewNews();
					System.out.println("q to go back");
					String in = br.readLine();
					if(in.equals("q"))
						break;
					else {
						System.out.println(Database.getDB().getNews().elementAt(in.charAt(0) - 49).getDescribtion());
					}
				}
				break;
			case "6":
				while(true) {
					System.out.println("Select course or enter q:");
					t.viewCourses();
					String choose = br.readLine();
					if(choose.equals("q"))
						break;
					Course[] myar = new Course[t.getSchedule().keySet().size()];
					t.getSchedule().keySet().toArray(myar);
					Course c = myar[Integer.parseInt(choose) - 1];
					while(true) {
						System.out.println("Choose student or enter 'q' to exit");
						Vector<Student> studs = new Vector<Student>();
						int pos = 1;
						for(Student s: c.getStudents().get(t)) {
							System.out.println(pos + " " + s.getFullName() + " " + s.getId());
							studs.add(s);
							pos++;
						}
						String com = br.readLine();
						if(com.equals("q"))
							break;
						
						MarkType[] ar = MarkType.values();
						int pos1 = 1;
						System.out.println("Choose mark type");
						for(MarkType m: ar) {
							System.out.println(pos1 + ". " + m);
							pos1++;
						}
						String choosemt = br.readLine();
						MarkType mt = ar[Integer.parseInt(choosemt) - 1];
						System.out.println("Put mark");
						String mark = br.readLine();
						System.out.println(studs.elementAt(Integer.parseInt(com) - 1));
						t.putMark(studs.elementAt(Integer.parseInt(com) - 1), c, Double.parseDouble(mark), mt);
						System.out.println("Success");
					}
				}
				break;
			case "7":
				t.viewMessages();
				break;
			case "8":
				t.viewSentMessages();
				break;
			case "9":
				System.out.println("Choose email of employee:");
				String mail = br.readLine();
				System.out.println("Write message:");
				String message = br.readLine();
				t.sendMessage(mail, message);
				
			}
				
				
		}
	}
}
