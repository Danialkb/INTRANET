package handlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

import java.util.Vector;
import java.util.stream.Collectors;

import coursecomponents.Course;
import users.Employee;
import users.Manager;
import users.Student;
import users.Teacher;
import users.User;

public final class Database implements Serializable{
	
	private Vector<Speciality> specialities;

    private HashSet<User> users;

    private Vector<Course> course;

    private Vector<News> news;
    
    private static Database db;
    
    private Database() {}
    
    {
    	users = new HashSet<User>();
    	specialities = new Vector<Speciality>();
    	course = new Vector<Course>();
    	news = new Vector<News>();
    }
    
    static {
    	db = null;
    }
    
    public HashSet<User> getUsers() {
        return users;
    }
   

    public Vector<Course> getCourse() {
        return course;
    }

    public Vector<News> getNews() {
        return news;
    }
    
    public Vector<Employee> getEmployee() {
    	if(users == null)return null;
        return users.stream().filter(u -> u instanceof Employee).
        		map(u -> (Employee) u).collect(Collectors.toCollection(Vector::new));
    }

    public Vector<Student> getStudent() {
    	if(users == null)return null;
        return users.stream().filter(u -> u instanceof Student).
        		map(u -> (Student) u).collect(Collectors.toCollection(Vector::new));
    }

	public Vector<Teacher> getTeacher() {
    	if(users == null)return null;
        return users.stream().filter(u -> u instanceof Teacher).
        		map(u -> (Teacher) u).
        		collect(Collectors.toCollection(Vector::new));
    }
    
	public Vector<Manager> getManager() {
    	if(users == null)return null;
        return users.stream().filter(u -> u instanceof Manager).
        		map(u -> (Manager) u).
        		collect(Collectors.toCollection(Vector::new));
    }
   
    public static Database getDB() {
    	if(db == null)
    		db = new Database();
    	return db;
    }
    
    public void addUser(User u) {
    	if(!users.contains(u))
    		users.add(u);
    }
    
    public void addCourse(Course c) {
    	if(!course.contains(c))
    		course.add(c);
    }
    
    public void addSpeciality(Speciality s) {
    	if(!specialities.contains(s))
    		specialities.add(s);
    }
    
    public void addNews(News n) {
    	if(!news.contains(n))
    		news.add(n);
    }


	public User getUser(String username) {
		for(User u: users) {
			if(u.getUsername().equals(username))
				return u;
		}
		return null;
	}
    
	public static void serialize() {
		try (FileOutputStream fos = new FileOutputStream("Db.ser")){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Database.getDB());
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("Db.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Database inst = (Database)ois.readObject();
			db = inst;
			fis.close();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
