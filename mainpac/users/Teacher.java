package users;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

import coursecomponents.Course;
import coursecomponents.File;
import coursecomponents.Lesson;
import coursecomponents.Mark;
import enums.JobTitle;
import enums.MarkType;
import enums.TeacherType;

public class Teacher extends Employee implements Serializable{
    private TeacherType type;

    
    private int sumRating = 0;
    private int countStudentsRated = 0;
    private HashMap<Course, Vector<Lesson>> schedule;
    private Double rating;
    
    public Teacher(String password, String fullname, String id, double salary,
    		JobTitle position, TeacherType type) {
    	super(password, fullname, id, salary, position);
    	this.type = type;
    }
    
    {
    	this.schedule = new HashMap<Course, Vector<Lesson>>();
    }

    //                          Operations                                  
    
    public void setRate(Integer rate) {
    	this.countStudentsRated++;
    	this.sumRating += rate;
    	this.rating = ((double)this.sumRating / (double)this.countStudentsRated);
    }
    
    public void putMark(Student s, Course c, double mark, MarkType mt){
    	if(mt == MarkType.MIDTERM)
    		s.getTranscript().getTranscript().put(c, new Mark(mark));
    	else if(mt == MarkType.ENDTERM)
    		s.getTranscript().getTranscript().get(c).setSecondAttestation(mark);
    	else 
    		s.getTranscript().getTranscript().get(c).setFinalexam(mark);
    }
    

	public void viewStudents(Course c) {        
        for(Student i: c.getStudents().get(this)) {
        	System.out.println(i.getFullName() + " " + i.getId());
        }
    }
	
	public Vector<Student> getStudents(Course c) {    
		Vector<Student> studs = new Vector<Student>();
        for(Student i: c.getStudents().get(this)) {
        	studs.add(i);
        }
        return studs;
    }

	public TeacherType getType() {
		return type;
	}

	public void setType(TeacherType type) {
		this.type = type;
	}

	public HashMap<Course, Vector<Lesson>> getSchedule() {
		return schedule;
	}

	public void setSchedule(HashMap<Course, Vector<Lesson>> schedule) {
		this.schedule = schedule;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public void addFile(Course c, File f) {
		if(c.getFiles().get(this) == null) {
			Vector<File> tmp = new Vector<File>();
			tmp.add(f);
			c.getFiles().put(this, tmp);
		}
		else
			c.getFiles().get(this).add(f);
	}
	
	public void delFile(Course c, File f) {
		c.getFiles().get(this).remove(f);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(countStudentsRated, rating, schedule, sumRating, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return countStudentsRated == other.countStudentsRated && Objects.equals(rating, other.rating)
				&& Objects.equals(schedule, other.schedule) && sumRating == other.sumRating && type == other.type;
	}
	
	
    
}
