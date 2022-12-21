package users;
import java.util.Vector;

import coursecomponents.Book;
import coursecomponents.Course;
import coursecomponents.File;
import coursecomponents.Lesson;
import coursecomponents.ManageCourses;
import coursecomponents.Transcript;
import enums.CourseStatus;
import enums.FacultyNames;
import enums.Organization;
import enums.StudentDegree;
import handlers.Request;
import handlers.Speciality;

import java.io.Serializable;
import java.util.HashMap;

import java.util.Objects;
import java.util.Queue;

public class Student extends User implements ManageCourses, Serializable{
    private Integer yearOfStudy;

    private StudentDegree degree;

    private FacultyNames faculty;

    private Vector<Organization> membership;

    private HashMap<Course, CourseStatus> courses;

    private Transcript transcript;

    private String phoneNumber;

    private HashMap<Course, Vector<Lesson>> schedule;
    
    private Speciality speciality;    
   
    private int totalCredits;
    
    private boolean passedQuestionary;
    
    public Student(String password, String fullname, String id, Integer yearOfStudy,
			StudentDegree degree, FacultyNames faculty, String phoneNumber,Speciality speciality) {
		super(password, fullname, id);
		this.yearOfStudy = yearOfStudy;
		this.degree = degree;
		this.faculty = faculty;
		this.phoneNumber = phoneNumber;
		this.speciality = speciality;
	}
    
    {
    	membership = new Vector<Organization>();
    	courses = new HashMap<Course, CourseStatus>();
    	transcript = new Transcript();
    	schedule = new HashMap<Course, Vector<Lesson>>();
    	passedQuestionary = true;
    	
    }
    
    public boolean isPassedQuestionary() {
		return passedQuestionary;
	}

	public void setQuestionary(boolean questionary) {
		this.passedQuestionary = questionary;
	}

	public void viewCourses() {
		int i = 1;
        for(Course c: this.courses.keySet()) {
        	System.out.println(i + ". " + c.getCode() + " " + c.getName() + " " + this.courses.get(c));
        	i++;
        }
    }
    
    public void viewTeachers() {
        Vector<Teacher> teach = new Vector<Teacher>();
        for(Course c: courses.keySet()) {
        	HashMap<Teacher, Vector<Student>> hm = c.getStudents();
        	for(Teacher t: hm.keySet()) {
        		if(hm.get(t).contains(this))
        			System.out.println(c.getName() + " " + t.getFullName());
        	}
        }
    }
    
    public Vector<Teacher> getTeachers(){
    	Vector<Teacher> teach = new Vector<Teacher>();
        for(Course c: courses.keySet()) {
        	HashMap<Teacher, Vector<Student>> hm = c.getStudents();
        	for(Teacher t: hm.keySet()) {
        		if(hm.get(t).contains(this))
        			teach.add(t);
        	}
        }
        return teach;
    }

	public void addCourse(Course c) {
    	if(c.getFaculty() == this.faculty  && this.totalCredits + c.getCredits() < 30 && this.courses.size() <= 6 && c.getCurNumStuds() != c.getLimit()) {
    		courses.put(c, CourseStatus.RUNNING);
    		this.transcript.getTranscript().put(c, null);
    	}
    	else {
    		System.out.println("You can't join this course");
    	}
    }

    public void dropCourse(Course c) {
        if(this.courses.get(c) != null) {
        	courses.remove(c);
        	this.transcript.getTranscript().remove(c);
        }
    }

    public void joinOrganization(Organization o) {
        if(!this.membership.contains(o))
        	this.membership.add(o);
        else System.out.println("You are already member of this organization!");
    }

    public void leaveOrganizations(Organization o) {
    	if(this.membership.contains(o))
        	this.membership.remove(o);
        else System.out.println("You are not member of this organization!");
    }
    
    public void viewOrganizations() {
    	for(Organization i: this.membership) {
    		System.out.println(i);
    	}
    }

    public Transcript getTranscript() {
        return this.transcript;
    }
    
    public void viewTranscript() {
    	System.out.println(this.transcript);
    }

    public void rateTeacher(Teacher t, Integer rate) {
    	t.setRate(rate);
    }

    public void addRequest(Request r) {
        Manager.getRequests().add(r);
    }
    
    public void viewRequests(){
    	Queue<Request> allReqs = Manager.getRequests();
    	for(Request r: allReqs) {
    		if(r.getFROM().equals(this))
    			System.out.println(r);
    	}
    }
    
    

    public HashMap<Course, Vector<Lesson>> getSchedule() {
		return schedule;
	}

	public void setSchedule(HashMap<Course, Vector<Lesson>> schedule) {
		this.schedule = schedule;
	}

	public boolean takeBook(Book b) {
        return Librarian.giveBooks(this, b);
    }
    
    public boolean returnBook(Book b) {
    	return Librarian.getBook(this, b);
    }
    
    public void viewSchedule() {
    	for(Course c: this.schedule.keySet()) {
    		System.out.println(c.getName());
    		for(Lesson l: this.schedule.get(c)) {
    			System.out.println(l);
    		}
    	}
    }
    
    
    
    public HashMap<Course, CourseStatus> getCourses() {
		return courses;
	}

	public void setCourses(HashMap<Course, CourseStatus> courses) {
		this.courses = courses;
	}

	public boolean pickLessons(Teacher t, Course c, Lesson l) {
		if(l.getLimit() <= 0)
			return false;
        for(Course cur: this.schedule.keySet()) {
        	for(Lesson i: this.schedule.get(cur)) {
        		int s1 = l.getTimeslot().getStartHour();
        		int s2 = i.getTimeslot().getStartHour();
        		int e1 = l.getTimeslot().getEndHour();
        		int e2 = i.getTimeslot().getEndHour();
        		if(l.getTimeslot().getDay() == i.getTimeslot().getDay() 
        				&& (s1 == s2 || e2 == e1 || (s1 > s2 && s1 < e2) 
        				|| (e1 > s2 && e1 < e2))) {
        			return false;
        		}
        	}
        }
        if(this.schedule.get(c) == null) {
        	Vector<Lesson> tmp = new Vector<Lesson>();
        	tmp.add(l);
        	this.schedule.put(c, tmp);
        }
        else
        	this.schedule.get(c).add(l);
    	l.setLimit(l.getLimit() - 1);
        return true;
    }
    

	@Override
    public int hashCode() {
    	final int prime = 31;
    	int result = super.hashCode();
    	result = prime * result + Objects.hash(courses, degree, faculty, membership, phoneNumber, schedule, speciality,
    			totalCredits, transcript, yearOfStudy);
    	return result;
    }

    public void viewCourseFiles(Teacher t, Course c) {
    	for(File f: c.getFiles().get(t)) {
    		System.out.println(f);
    	}
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (!super.equals(obj))
    		return false;
    	if (getClass() != obj.getClass())
    		return false;
    	Student other = (Student) obj;
    	return Objects.equals(courses, other.courses) && degree == other.degree && faculty == other.faculty
    			&& Objects.equals(membership, other.membership) && Objects.equals(phoneNumber, other.phoneNumber)
    			&& Objects.equals(schedule, other.schedule) && Objects.equals(speciality, other.speciality)
    			&& totalCredits == other.totalCredits && Objects.equals(transcript, other.transcript)
    			&& Objects.equals(yearOfStudy, other.yearOfStudy);
    }
    
    @Override
    public String toString() {
    	return "Student " + this.getFullName() + " " + this.getId() + ", [yearOfStudy=" + yearOfStudy + ", degree=" + degree + ", faculty=" + faculty + ", phoneNumber=" + phoneNumber
    		 + ", speciality=" + speciality.getName() + ", totalCredits=" + totalCredits + "]";
    }

    
}
