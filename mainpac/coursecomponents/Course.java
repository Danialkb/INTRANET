package coursecomponents;

import java.util.Vector;

import enums.CourseStatus;
import enums.CourseType;
import enums.FacultyNames;
import enums.SemestrType;
import users.Student;
import users.Teacher;

import java.io.Serializable;
import java.util.HashMap;

public class Course implements Serializable{
    private String name;
    
    private String code;
    
    private Integer credits;

    private String description;
    
    private File courseFiles;

    private FacultyNames faculty;
 
    private Integer limit;
 
    private Vector<Vector<Lesson>> lessons;
 
    private HashMap<Teacher, Vector<File>> files;
  
    private Vector<SemestrType> semestr;
  
    private HashMap<Teacher, Vector<Student>> students;
    
	private Vector<Student> allStuds;
    
    private String prerequisite;

    private Integer year;
    
    private Teacher teacher;

    private int curNumStuds;
    
    private CourseStatus status;
    
    private CourseType type;
    
    public Course(String name, String code, Integer credits, String description, 
    		FacultyNames faculty, Integer limit, String prerequisite, Integer year, 
    		int curNumStuds, CourseType ct) {
		super();
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.description = description;
		this.faculty = faculty;
		this.limit = limit;
		this.prerequisite = prerequisite;
		this.year = year;
		this.curNumStuds = curNumStuds;
		this.type = ct;
	}
    
    {
    	lessons = new Vector<Vector<Lesson>>();
    	files = new HashMap<Teacher, Vector<File>>();
    	students = new HashMap<Teacher, Vector<Student>>();
    	allStuds = new Vector<Student>();
    	semestr = new Vector<SemestrType>();
    	status = CourseStatus.RUNNING;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getCourseFiles() {
		return courseFiles;
	}

	public void setCourseFiles(File courseFiles) {
		this.courseFiles = courseFiles;
	}

	public Vector<Vector<Lesson>> getLessons() {
		return lessons;
	}

	public HashMap<Teacher, Vector<Student>> getStudents(){
		return this.students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Vector<SemestrType> getSemestr() {
		return semestr;
	}

	public void setSemestr(Vector<SemestrType> semestr) {
		this.semestr = semestr;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FacultyNames getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyNames faculty) {
		this.faculty = faculty;
	}
	
	
	
	public HashMap<Teacher, Vector<File>> getFiles() {
		return files;
	}

	public void setFiles(HashMap<Teacher, Vector<File>> files) {
		this.files = files;
	}

	public int getCurNumStuds() {
		return curNumStuds;
	}

	public void setCurNumStuds(int curNumStuds) {
		this.curNumStuds = curNumStuds;
	}
	
	

    public void addStudent(Student s) {
    	if(!allStuds.contains(s))
    		this.allStuds.add(s);
    	
    }

	public void addFile(Teacher t, File f) {
		if(this.files.get(t) == null) {
			Vector<File> tmp = new Vector<File>();
			tmp.add(f);
			this.files.put(t, tmp);
		}
		else {
			this.files.get(t).add(f);
		}
		
	}

	public void delFile(Teacher t, File f) {
		this.files.get(t).remove(f);
	}	

	public CourseStatus getStatus() {
		return status;
	}

	public void setStatus(CourseStatus status) {
		this.status = status;
	}

	public void addLesson(Vector<Lesson> l) {
		this.lessons.add(l);
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", code=" + code + ", credits=" + credits + ", description=" + description
				+ ", faculty=" + faculty + ", limit=" + limit +  "type=" + type + "]";
	}
    
    
}
