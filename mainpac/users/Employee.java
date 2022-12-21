package users;
import java.util.Vector;

import enums.JobTitle;
import handlers.CanSendMessage;
import handlers.Message;



public class Employee extends User implements CanSendMessage{
    private double salary;

    private Vector<Message> messages;
    
    private Vector<Message> sendMessages;

	private JobTitle position;
	
	public Employee(String password, String fullname, String id, double salary,JobTitle position) {
		super(password, fullname, id);
		this.salary = salary;
		this.position = position;
	}
	
	{
		this.messages = new Vector<Message>();
		this.sendMessages = new Vector<Message>();
	}
    
    public void getMessage(Message s) {
    	messages.add(s);
    }
    
    public void sendMessage(Employee e, String s) {
    	this.sendMessages.add(new Message(this, e, s));
        e.getMessage(new Message(this, e, s));
    }

    public Vector<Message> viewMessages() {
        return this.messages;
    }
    
    public Vector<Message> viewSentMessages() {
        return this.sendMessages;
    }

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public JobTitle getPosition() {
		return position;
	}

	public void setPosition(JobTitle position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return super.toString() + " Employee [salary=" + salary + ", messages=" + messages + ", sendMessages=" + sendMessages
				+ ", position=" + position + "]";
	}
	
	
    
    
}
