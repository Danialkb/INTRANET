package UsersDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import handlers.Database;
import users.Student;
import users.Teacher;

public class testSerializ {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("myser.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Database inst = (Database)ois.readObject();
		ois.close();
		fis.close();
		for(Student i: inst.getStudent()) {
			System.out.println(i);
		}
		for(Teacher t: inst.getTeacher()) {
			System.out.println(t);
		}
	}

}
