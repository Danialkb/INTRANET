package UsersDemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.crypto.Data;

import enums.FacultyNames;
import enums.StudentDegree;
import handlers.Database;
import handlers.Speciality;
import users.Student;
import users.User;

public class Menu {
	
	public static void main(String[] args) throws IOException{
		
		Speciality is = new Speciality("Information Systems", FacultyNames.SITE);
		
		Student s1 = new Student("123", "Togzhan Beldeubaeva", "21B031121", 2, StudentDegree.BACHELOR, FacultyNames.SITE, "87777826521", is);
		Student s2 = new Student("123", "Danial Bidaibek", "21B031193", 2, StudentDegree.BACHELOR, FacultyNames.SITE, "87779316622", is);
		Database.getDB().addUser(s1);
		Database.getDB().addUser(s2);
		
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
			        System.out.print("Password: ");
			        String password = reader.readLine();
			        
					User cur = Database.getDB().getUser(username);
					
					if(cur != null && cur.logIn(username, password)) {
						System.out.println(cur);
						if (cur instanceof Student) {
							StudentMenu.studentMenu((Student)cur);
						}
					}
					else {
						System.out.println("No such user");
					}
				} else if (input.equals("2")) {
					System.out.println("\nLog out of the system");
				}
			}
		} catch (IOException exception) {
            System.out.println("Exception");
        }
	}	
}	