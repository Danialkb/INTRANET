package handlers;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

import coursecomponents.Course;
import enums.FacultyNames;


public class Speciality implements Serializable{
    private String name;

    private Vector<Course> courses = new Vector<Course>();

    private FacultyNames faculty;

    public Speciality(String name, FacultyNames faculty) {
    	super();
    	this.name = name;
    	this.faculty = faculty;
    }
    
    
    
    

    //                          Operations                                  

    public String getName() {
    	return this.name;
    }



	public void addCourse(Course c) {
        this.courses.add(c);
    }





	@Override
	public int hashCode() {
		return Objects.hash(courses, faculty, name);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Speciality other = (Speciality) obj;
		return Objects.equals(courses, other.courses) && faculty == other.faculty && Objects.equals(name, other.name);
	}





	@Override
	public String toString() {
		return "Speciality [name=" + name + ", faculty=" + faculty + "]";
	}


    
    
}
