package handlers;

import java.util.Comparator;

import users.User;

public class StudentsSort implements Comparator<User> {
	public int compare(User o1, User o2) {
		return o1.getFullName().compareTo(o2.getFullName());
	}
}