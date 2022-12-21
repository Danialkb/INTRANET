package coursecomponents;

import java.io.Serializable;
import java.util.HashMap;

import enums.CourseStatus;
import users.Student;

public class Transcript implements Serializable {
	private Double gpa;

    private HashMap<Course, Mark>  transcript = new HashMap<Course, Mark>();

    private Integer totalCredits;

    //                          Operations             

    public Transcript() {}
    
	public Transcript(double gpa, HashMap<Course, Mark> transcript, Integer totalCredits) {
		super();
		this.gpa = gpa;
		this.transcript = transcript;
		this.totalCredits = totalCredits;
	}
	
	{
		this.totalCredits = 0;
	}
	
	public HashMap<Course, Mark> getTranscript() {
		return transcript;
	}
	
	public Double getGpa() {
		this.gpa = this.calculateGpa();
		return this.gpa;
	}


	public Integer getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}

	public void setTotalCredits() {
		for(Course c: this.transcript.keySet()) {
			if(this.transcript.get(c).getFinalexam() != null) {
				this.totalCredits += c.getCredits();
			}
		}
	}
	
	private double calculateGpa() {
        double total = 0.0;
        
        for(Course c: this.transcript.keySet()) {
        	if(this.transcript.get(c) != null) {
        		if(this.transcript.get(c).getFinalexam() != null) {
	        		total += this.transcript.get(c).getGPA();
	        		if(this.transcript.get(c).getGPA() == 0.0)
	        			c.setStatus(CourseStatus.RETAKE);
	        		else
	        			c.setStatus(CourseStatus.FINISHED);
        		}
        	}
        }
        
        return total / this.totalCredits;
    }
	
	 public String toString() {
		 String ans = "";
		 for(Course c: this.transcript.keySet()) {
			 if(this.transcript.get(c) != null) {
				 ans += c.getName() + " " + " " 
			 + this.transcript.get(c).getTotalAttestation() 
			 + this.transcript.get(c).getMark() + "\n";
			 }
		 }
		    return
		        "Transcript: " + ans + 
		        "Total Credits: " + this.getTotalCredits() + 
		        "\nGPA: " + this.getGpa();
	  } 
    
}
