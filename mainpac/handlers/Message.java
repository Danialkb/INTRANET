package handlers;

import java.io.Serializable;
import java.util.Date;

import users.Employee;

public class Message implements Serializable {
    private String text;

    private Employee FROM;

    private Employee TO;
    
    private Date DATE;
    
    public Message(Employee from, Employee to, String text) {
    	this.FROM = from;
    	this.TO = to;
    	this.text = text;
    	this.DATE = new Date();
    }
    	
    
    
	@Override
	public String toString() {
		return "Message [text=" + text + ", FROM=" + FROM.getFullName() + ", TO=" + TO.getFullName() + ", DATE=" + DATE + "]";
	}
    
    
    
}
