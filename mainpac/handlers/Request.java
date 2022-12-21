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
    
    private RequestType type;

    private RequestStatus status;

    private Student FROM;
    
    private File file;
 
    public Request(RequestType rt, Student f) {
    	this.type = rt;
    	this.FROM = f;
    }
    
    {
    	this.status = RequestStatus.PROCESSING;
    	this.date = new Date();
    }

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Request [date=" + date + ", type=" + type + ", status=" + status + ", FROM="
				+ FROM.getFullName() + " " + FROM.getId() + "]";
	}
	
    
    
}
