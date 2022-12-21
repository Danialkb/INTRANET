package handlers;

import java.util.Vector;

import users.Employee;

public interface CanSendMessage {
	public void sendMessage(String email, String s);
	public void getMessage(Message m);
	public void viewMessages();
	public void viewSentMessages();
}
