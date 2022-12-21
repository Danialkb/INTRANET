package handlers;

import java.util.Comparator;

import users.Teacher;

public class TeachersSort implements Comparator<Teacher>{

	public int compare(Teacher o1, Teacher o2) {
		return o1.getFullName().compareTo(o2.getFullName());
	}

}