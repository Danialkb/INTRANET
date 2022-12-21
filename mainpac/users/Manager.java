package users;

import java.util.Set;
import java.util.Vector;

import javax.xml.crypto.Data;

import coursecomponents.Course;
import coursecomponents.File;
import coursecomponents.Lesson;
import coursecomponents.ManageCourses;
import coursecomponents.Mark;
import enums.JobTitle;
import enums.ManagerTitle;
import enums.RequestStatus;
import handlers.Database;
import handlers.News;
import handlers.Request;
import handlers.StudentsSort;
import handlers.TeachersSort;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Manager extends Employee implements Serializable, ManageCourses{
	private ManagerTitle zone;

    private static Queue<Request> requests;

    public Manager(String password, String fullname, String id, double salary,
    		JobTitle position, ManagerTitle zone) {
    	super(password, fullname, id, salary, position);
    	this.zone = zone;
    }
    
    static{
    	requests = new LinkedList<Request>();
    }
    
    public static Queue<Request> getRequests() {
        return requests;
    }
    
    public void addCourse(Course c) {
    	Database.getDB().addCourse(c);
    }
    
    public void viewTeachers() {
    	for(Teacher t: Database.getDB().getTeacher()) {
    		System.out.println(t);
    	}
    }

    public void viewStudents() {
        for(Student s: Database.getDB().getStudent()) {
        	System.out.println(s);
        }
    }
   
    public static boolean approveRegistration(Student s, Course c) {
        HashMap<Course, Mark> hm = s.getTranscript().getTranscript();
        String pre = c.getPrerequisite();
        if(pre == null)return true;
        for(Course cur: hm.keySet()) {
        	if(cur.getCode().equals(pre)) {
        		if(hm.get(cur) != null) {
        			if(hm.get(cur).getFinalexam() >= 20.0) {
        				return true;
        			}
        			else
        				return false;
        		}
        		else
        			return false;
        	}
        }
       return false;
    }
    
    public void startQuestionary() {
    	Vector<Student> allstuds = Database.getDB().getStudent();
    	for(Student i: allstuds)
    		i.setQuestionary(false);
    }

    public void approveRequest(Request r, File f) {
        int cnt = 0;
        for(Request i: requests) {
        	if(i.getFROM().equals(r.getFROM()) && i.getType() == r.getType()) {
        		cnt++;
        	}
        }
        if(cnt > 3)
        	r.setStatus(RequestStatus.REJECTED);
        else
        	r.setStatus(RequestStatus.COMPLETED);
    }

    public void setCourseForTeacher(Teacher t, Course c, Vector<Lesson> lessons) {
        t.getSchedule().put(c, lessons);
    }
    
    public void addNews(String title, String text, Date date) {
    	News news = new News(title, text, date);
        Database.getDB().addNews(news);
    }

    public void updateNews(News updatingNew, String description) {
    	updatingNew.setDescribtion(description);
    }
    
    public void delNews(Vector<News> news, News news2) {
    	Database.getDB().getNews().remove(news2);
    }

    public void viewTeachersAlphabetically() {
    	Vector<Teacher> allTeachers = Database.getDB().getTeacher();
    	Collections.sort(allTeachers, new TeachersSort());
        
    	for(Teacher i: allTeachers) {
    		System.out.println(i);
    	}
    }

    public void viewStudentsAlphabetically() {
    	Vector<Student> allStudents = Database.getDB().getStudent();
    	Collections.sort(allStudents, new StudentsSort());
        
    	for(Student s: allStudents) {
    		System.out.println(s);
    	}
    	
    }

    public void createStaticticalReport() {
      
    }

	@Override
	public void dropCourse(Course c) {
		if(Database.getDB().getCourse().contains(c))
			Database.getDB().getCourse().remove(c);
	}

	@Override
	public String toString() {
		return super.toString() + " Manager [zone=" + zone + "]";
	}
    
	
    
}
