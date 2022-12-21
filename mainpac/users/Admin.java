package users;

import java.io.Serializable;

import enums.JobTitle;
import handlers.Database;
import handlers.Message;


public class Admin extends Employee implements Serializable{

	public Admin(String password, String fullname, String id, double salary,
			JobTitle position) {
		super(password, fullname, id, salary, position);
	}

    public void viewUsers() {
        for(User u: Database.getDB().getUsers()) {
        	System.out.println(u);
        }
    }

    public void addUser (User u) {
        Database.getDB().addUser(u);
    }


    public void deleteUser(User u) {
        Database.getDB().getUsers().remove(u);
    }

    public void updateUser(User u, String password) {
        u.setPassword(password.hashCode());
    }
    
}
