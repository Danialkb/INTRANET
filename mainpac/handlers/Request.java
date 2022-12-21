package handlers;

import java.io.Serializable;
import java.util.Date;

import coursecomponents.File;
import enums.RequestStatus;
import enums.RequestType;
import enums.SemestrType;
import users.Student;

public class Request implements Serializable {
    private Date date;
    
    private SemestrType semestr;

    private RequestType type;

    private RequestStatus status;

    private Student FROM;

    private Student student;
    
    private File file;
 
    public Request(Date d, SemestrType sem, RequestType rt, RequestStatus status) {
    	this.date = d;
    	this.semestr = sem;
    	this.type = rt;
    	this.status = status;
    }

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SemestrType getSemestr() {
		return semestr;
	}

	public void setSemestr(SemestrType semestr) {
		this.semestr = semestr;
	}

	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public Student getFROM() {
		return FROM;
	}

	public void setFROM(Student fROM) {
		FROM = fROM;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Request [date=" + date + ", semestr=" + semestr + ", type=" + type + ", status=" + status + ", FROM="
				+ FROM + ", student=" + student + "]";
	}
	
    
    
}
