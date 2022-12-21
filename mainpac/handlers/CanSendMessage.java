package handlers;

import java.util.Vector;

import users.Employee;

public interface CanSendMessage {
	public void sendMessage(Employee e, String s);
	public void getMessage(Message m);
	public Vector<Message> viewMessages();
	public Vector<Message> viewSentMessages();
}
