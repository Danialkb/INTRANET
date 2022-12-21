package UsersDemo;


import handlers.Database;
import users.Employee;
import users.Student;
import users.Teacher;

public class testSerializ {

	public static void main(String[] args){
		Database.deserialize();
		
		for(Student i: Database.getDB().getStudent()) {
			System.out.println(i);
		}
		for(Teacher t: Database.getDB().getTeacher()) {
			System.out.println(t);
		}
		
		for(Employee e: Database.getDB().getEmployee()) {
			System.out.println(e);
		}
	}

}
