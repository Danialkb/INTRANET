package coursecomponents;
import java.io.Serializable;

import users.Student;

public class Mark implements Serializable {
    private Double firstAttestation = null;

    private Double secondAttestation = null;

    private String mark;

    private Double finalexam = null;
    
    private Double gpa = null;
    
    private Double totalAttestation = 0.0;
    
    public Mark(double firstAttestation) {
		super();
		this.firstAttestation = firstAttestation;
	}
    
    public Mark(double firstAttestation, double secondAttestaion) {
		this(firstAttestation);
		this.secondAttestation = secondAttestaion;
	}
    
    public Mark(double firstAttestation, double secondAttestaion, double finalexam) {
		this(firstAttestation, secondAttestaion);
		this.finalexam = finalexam;
	}
    
//    {
//    	this.firstAttestation = null;
//    	this.secondAttestation = null;
//    	this.finalexam = null;
//    	this.totalAttestation = 0.0;
//    	this.gpa = null;
//    }


	public Double getFirstAttestation() {
		return firstAttestation;
	}

	private void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public Double getGPA() {
		return this.gpa;
	}

	public void setFirstAttestation(double firstAttestation) {
		this.firstAttestation = firstAttestation;
		this.totalAttestation += this.firstAttestation;
	}


	public Double getSecondAttestation() {
		return secondAttestation;
	}


	public void setSecondAttestation(double secondAttestation) {
		this.secondAttestation = secondAttestation;
		this.totalAttestation += this.secondAttestation;
	}


	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}


	public Double getFinalexam() {
		
		return finalexam;
	}


	public void setFinalexam(double finalexam) {
		this.finalexam = finalexam;
		this.totalAttestation += this.finalexam;
		
		String[] marks = {"F", "F", "F", "F", "F", "F", "F", "F", "F", "F", 
				"D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A"};
		double[] marks1 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 
				1.0, 1.33, 1.67, 2.0, 2.33, 2.67, 3.0, 3.33, 3.67, 4.0};
		this.setMark(marks[(int)(Math.round((this.totalAttestation) / 5))]);
		this.setGPA(marks1[(int)(Math.round((this.totalAttestation) / 5))]);
	}
	

	public Double getTotalAttestation() {
		return totalAttestation;
	}

	public void setTotalAttestation(Double totalAttestation) {
		this.totalAttestation = totalAttestation;
	}

	@Override
	public String toString() {
		return this.totalAttestation + " " + this.mark;
	}
	
	
    
}
